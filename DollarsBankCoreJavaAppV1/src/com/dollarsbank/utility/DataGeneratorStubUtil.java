package com.dollarsbank.utility;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class DataGeneratorStubUtil {
	
	// Internal list of customers: serves as database stand in
	public static List<Customer> customerList = new ArrayList<Customer>();
	
	// Create an account when given all information
	public static void createAccount(String name, String address, int contactNum, String userId, String password, float initDeposit) {
		customerList.add(new Customer(name, address, contactNum, new SavingsAccount(userId, password, initDeposit)));
	}
	
	// Create an account when given customer data and a savings account
	public static void createAccount(String name, String address, int contactNum, SavingsAccount savings) {
		customerList.add(new Customer(name, address, contactNum, savings));
	}
	
	// Create an account from an existing customer
	public static void createAccount(Customer customer) {
		customerList.add(customer);
	}

}
