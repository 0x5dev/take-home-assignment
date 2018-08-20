package com.duke.assignment.dao;

import java.util.List;

import com.duke.assignment.model.FoodTruck;

public interface FoodTruckRepo {

	List<FoodTruck> getAllFoodTrucks();

	List<FoodTruck> getFoodTrucksByDayOfWeek(int dayOfWeek);

}