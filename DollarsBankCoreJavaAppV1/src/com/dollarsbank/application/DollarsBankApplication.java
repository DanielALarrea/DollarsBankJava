package com.dollarsbank.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DollarsBankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDateTime localTime = LocalDateTime.now();
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = localTime.format(formatTime);
		System.out.println(localTime);
		System.out.println(formattedDate);
	}

}
