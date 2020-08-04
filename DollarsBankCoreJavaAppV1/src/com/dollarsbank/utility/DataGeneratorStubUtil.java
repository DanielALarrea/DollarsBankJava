package com.dollarsbank.utility;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class DataGeneratorStubUtil {
	
	// Internal list of customers: serves as database stand in
	public static List<Customer> customerList = new ArrayList<Customer>();
	
	// Create an account when given all information
	public static void createAccount(String name, String address, String contactNum, String userId, String password, float initDeposit) {
		customerList.add(new Customer(name, address, contactNum, new SavingsAccount(userId, password, initDeposit)));
	}
	
	// Create an account when given customer data and a savings account
	public static void createAccount(String name, String address, String contactNum, SavingsAccount savings) {
		customerList.add(new Customer(name, address, contactNum, savings));
	}
	
	// Create an account from an existing customer
	public static void createAccount(Customer customer) {
		customerList.add(customer);
	}
	
	public static void initializeTestAccounts() {
		SavingsAccount testSavings1 = new SavingsAccount("U01", "Pa$$word", 500);
		Customer testCustomer1 = new Customer("Jane Jackson", "Minneapolis, MN", "223-456-7890", testSavings1);
		DataGeneratorStubUtil.createAccount(testCustomer1);
		
		SavingsAccount testSavings2 = new SavingsAccount("U02", "P@ssword", 300);
		Customer testCustomer2 = new Customer("Joe Johnson", "Houston, TX", "323-456-7890", testSavings2);
		DataGeneratorStubUtil.createAccount(testCustomer2);
		
		String testTransaction1 = ConsolePrinterUtility.printAccountCreation(testSavings1.getUserId()) + "\n"
				+ ConsolePrinterUtility.printCurrentBalanceAndTime(testSavings1);
		DollarsBankController.pushTransaction(testSavings1, testTransaction1);

		String testTransaction2 = ConsolePrinterUtility.printAccountCreation(testSavings2.getUserId()) + "\n"
				+ ConsolePrinterUtility.printCurrentBalanceAndTime(testSavings2);
		DollarsBankController.pushTransaction(testSavings2, testTransaction2);
	}

}
