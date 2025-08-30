package com.izt.attendance.model;

import java.time.LocalDate;

public class Employee {
	private int id_num;
	private String name;
	private String department;
	private LocalDate joiningDate;
	
	public Employee(int id, String name, String department) {
        this.id_num = id;
        this.name = name;
        this.department = department;
        //this.joinDate = joinDate;
    }

	public int getId_num() {
		return id_num;
	}

	public void setId_num(int id_num) {
		this.id_num = id_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	
}
