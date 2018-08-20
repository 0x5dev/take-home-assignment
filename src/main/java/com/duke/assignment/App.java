package com.duke.assignment;

import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.duke.assignment.dao.FoodTruckRepo;
import com.duke.assignment.model.FoodTruck;

public class App {
	
	private static ApplicationContext ctx;

	public static void main(String[] args) {
   				
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		   
		FoodTruckRepo foodTruckRepo = ctx.getBean(FoodTruckRepo.class);
		FoodTruckPrinter foodTruckPrinter = ctx.getBean(FoodTruckPrinter.class);
		
		List<FoodTruck> foodTrucks = foodTruckRepo.getFoodTrucksByDayOfWeek(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
		
		foodTruckPrinter.printFoodTrucks(foodTrucks);
	}	
}