package com.izt.attendance;

import java.time.LocalTime;

public class TestGround {

	public static void main(String[] args) {
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		System.out.println(lt.getHour()); 
	}

}
