package com.duke.assignment;
import org.springframework.context.annotation.*;

import com.duke.assignment.dao.FoodTruckRepo;
import com.duke.assignment.dao.FoodTruckRepoImpl;

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