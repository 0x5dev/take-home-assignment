package com.anonymity.assignment.client;
import org.springframework.context.annotation.*;

import com.anonymity.assignment.dao.FoodTruckRepo;
import com.anonymity.assignment.dao.FoodTruckRepoImpl;

@Configuration
public class AppConfig {
	
	@Bean 
	public FoodTruckRepo foodTruckRepo(){
		return new FoodTruckRepoImpl();
	}
	
	@Bean
	public FoodTruckPrinter foodTruckPrinter() {
		return new FoodTruckPrinterImpl();
	}
}