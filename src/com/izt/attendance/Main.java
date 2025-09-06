package com.izt.attendance;

import java.time.LocalTime;

import com.izt.attendance.model.Employee;

public class Main {

	public static void main(String[] args) {
		Employee empl_1 = new Employee(1, "Ishwar", "Product Development");
		Employee empl_2 = new Employee(2, "Gautam", "Finance Dept.");
		System.out.println(empl_1);
		System.out.println(empl_2);
		
		LocalTime lt= LocalTime.now();
		System.out.println();
	}

}