package com.anonymity.assignment.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.anonymity.assignment.model.FoodTruck;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodTruckRepoImpl implements FoodTruckRepo {

	public List<FoodTruck> getAllFoodTrucks() {
		String jsonString = null;

		System.out.println("Loading......");
		
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL("http://data.sfgov.org/resource/bbb8-hzi6.json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			conn.disconnect();
			rd.close();
			jsonString = result.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		List<FoodTruck> trucks = null;

		try {
			trucks = mapper.readValue(jsonString, new TypeReference<List<FoodTruck>>() {});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		return trucks;
	}

	public List<FoodTruck> getFoodTrucksByDayOfWeek(int dayOfWeek) {
		
		String dayOfWeekStr = getDayOfWeek(dayOfWeek);
		
		List<FoodTruck> foodTrucks = getAllFoodTrucks();
		
		// Get food trucks that open today
		List<FoodTruck> todaysFoodTrucks = foodTrucks.stream().filter(foodTruck -> foodTruck.getDayofweekstr().equalsIgnoreCase(dayOfWeekStr)).collect(Collectors.toList());
		
		// Sort food trucks by name
		if (todaysFoodTrucks != null && todaysFoodTrucks.size() != 0) {
			todaysFoodTrucks.sort((FoodTruck a, FoodTruck b) -> a.getApplicant().compareTo(b.getApplicant()));
		}
		
		return todaysFoodTrucks;
	}
	
	private String getDayOfWeek(int dayOfWeek) {
		String day = "";
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			day = "Sunday";
			break;
		case Calendar.MONDAY:
			day = "Monday";
			break;
		case Calendar.TUESDAY:
			day = "Tuesday";
			break;
		case Calendar.WEDNESDAY:
			day = "Wednesday";
			break;
		case Calendar.THURSDAY:
			day = "Thursday";
			break;
		case Calendar.FRIDAY:
			day = "Friday";
			break;
		case Calendar.SATURDAY:
			day = "Saturday";
			break;
		}
		return day;
	}
}
