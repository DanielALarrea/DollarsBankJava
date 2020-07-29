package com.dollarsbank.utility;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class DataGeneratorStubUtil {
	
	public List<Customer> customerList = new ArrayList<Customer>();
	
	public void createAccount(String name, String address, int contactNum, String userId, String password, float initDeposit) {
		//System.out.println(name + ", " + address + ", " + contactNum + ", " + userId + ", " + password + ", " + initDeposit);
		customerList.add(new Customer(name, address, contactNum, new SavingsAccount(userId, password, initDeposit)));
	}
	
	public void createAccount(Customer customer) {
		customerList.add(customer);
	}

}
