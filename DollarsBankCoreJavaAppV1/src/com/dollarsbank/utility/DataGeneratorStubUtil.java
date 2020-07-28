package com.dollarsbank.utility;

import java.util.List;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class DataGeneratorStubUtil {
	
	public List<Customer> customerList;
	
	public void createAccount(String name, String address, int contactNum, String userId, String password, int initDeposit) {
		Account savingsAccount = new SavingsAccount(userId, password, initDeposit);
		Customer customer = new Customer(name, address, contactNum, savingsAccount);
		customerList.add(customer);
	}

}
