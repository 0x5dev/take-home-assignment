package com.anonymity.assignment.dao;

import java.util.List;

import com.anonymity.assignment.model.FoodTruck;

public interface FoodTruckRepo {

	List<FoodTruck> getAllFoodTrucks();

	List<FoodTruck> getFoodTrucksByDayOfWeek(int dayOfWeek);

}