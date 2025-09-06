package com.izt.attendance.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.izt.attendance.AttendanceStatus;

public class AttendanceRecord {
	private Employee employee; // Employee object has 'id, name, department' variables
	private LocalDate date;
	private LocalTime loginTime;
	private LocalTime logoutTime;

	public AttendanceRecord(String empIdd, String date, String inTime, String outTime) {
		// this.employee = EmployeeService.getEmployeeById(empId);

		// Parse date
		this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		// Parse login time (handle null/empty)
		this.loginTime = parseTime(inTime);

		// Parse logout time (handle null/empty)
		this.logoutTime = parseTime(outTime);

		// Validate logical consistency
		validateAttendanceData();
	}

	private void validateAttendanceData() {
		if (this.loginTime.isAfter(this.logoutTime))
			throw new IllegalArgumentException("Invalid Time Format..");

	}

	/**
	 * 
	 * @param timeStr : In any format HH:MM , HH:MM:SS
	 * @return
	 */
	private LocalTime parseTime(String timeStr) {
		if (timeStr.length() == 5) { // HH:MM
			LocalTime lt = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
			return lt;
		} else if (timeStr.length() == 8) {
			LocalTime lt = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
			return lt;
		}
		return null;
	}

	public long getWorkedHours() {
		return java.time.Duration.between(this.loginTime, this.logoutTime).toHours();
	}

	public AttendanceStatus getAttendanceStatus() {
		if (this.loginTime == null)
			return AttendanceStatus.ABSENT;
		else if (getWorkedHours() > 8)
			return AttendanceStatus.FULL_DAY;
		else if (getWorkedHours() > 4)
			return AttendanceStatus.HALF_DAY;
		else
			return AttendanceStatus.SHORT_HOURS;
	}

	@Override
	public String toString() {
		return String.format("AttendanceRecord{employee=%s, date=%s, loginTime=%s, logoutTime=%s, status=%s}",
				employee.getName(), date, loginTime, logoutTime, getAttendanceStatus());
	}
}
