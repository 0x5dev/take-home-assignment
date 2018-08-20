package com.duke.assignment;

import java.util.List;
import java.util.Scanner;

import com.duke.assignment.model.FoodTruck;

public class FoodTruckPrinterImpl implements FoodTruckPrinter {

	public void printFoodTrucks(List<FoodTruck> foodTrucks) {

		Scanner scanner = new Scanner(System.in);
		
		int totalNum = foodTrucks.size();
		int startIndex = 0;
		int page = 1;
		
		while (true) {
			
			int i = startIndex;
			
			for (; i < startIndex + 10 && i < totalNum; i++) {
				System.out.println("NAME: " + foodTrucks.get(i).getApplicant());
				System.out.println("ADDRESS: " + foodTrucks.get(i).getLocation());
				System.out.println();
			}
			
			startIndex = i;
			
			if (startIndex == totalNum) {
				System.out.println("--------------Page " + page + ", This Is Last Page--------------");
				break;
			}
			
			System.out.println("---------Page " + page + ", Press Enter To See Next Page---------");
			
			String string = scanner.nextLine();
			if (string.equals("")) {
				page++;
				continue;
			}			
		}
		
		scanner.close();
	}
}
