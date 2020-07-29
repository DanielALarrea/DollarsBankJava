package com.dollarsbank.controller;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankController {
//	DataGeneratorStubUtil data = new DataGeneratorStubUtil();
	
//	public void depositAmount(Customer customer, float deposit) {
//		SavingsAccount savings = (SavingsAccount) customer.getBankAccount();
//		savings.deposit(deposit);
//		customer.setBankAccount(savings);
//	}
//	
//	public void withdrawAmount(Customer customer, float withdraw) {
//		SavingsAccount savings = (SavingsAccount) customer.getBankAccount();
//		savings.withdraw(withdraw);
//		customer.setBankAccount(savings);
//	}
//	
//	public void transferFunds(Customer customerFrom, Customer customerTo, float amount) {
//		SavingsAccount savingsFrom = (SavingsAccount) customerFrom.getBankAccount();
//		SavingsAccount savingsTo = (SavingsAccount) customerTo.getBankAccount();
//		savingsFrom.withdraw(amount);
//		savingsTo.deposit(amount);
//		customerFrom.setBankAccount(savingsFrom);
//		customerTo.setBankAccount(savingsTo);
//	}
	
	public static void depositAmount(SavingsAccount savings, float deposit) {
		savings.deposit(deposit);
	}
	
	public static void withdrawAmount(SavingsAccount savings, float withdraw) {
		savings.withdraw(withdraw);
	}
	
	public static void transferFunds(SavingsAccount savingsFrom, SavingsAccount savingsTo, float amount) {
		savingsFrom.withdraw(amount);
		savingsTo.deposit(amount);
	}
	
	public Customer retrieveCustomerFromAccount(Account account, DataGeneratorStubUtil data) {
		Customer customer = new Customer();
		for (Customer cu: data.customerList) {
			if (cu.getBankAccount() == account) {
				customer = cu;
			}
		}
		
		return customer;
	}
	
	public Account retrieveAccountFromUserAndPass(String user, String pass,  DataGeneratorStubUtil data) {
		Account account = new Account(user, pass);
		for (Customer cu: data.customerList) {
			if (cu.getBankAccount() == account) {
				account = cu.getBankAccount();
			}
		}
		
		return account;
	}
	
	public boolean validLogin(String user, String pass, DataGeneratorStubUtil data) {
		boolean validLogin = false;
		for (Customer cu: data.customerList) {
			if (user.equals(cu.getBankAccount().getUserId()) && pass.equals(cu.getBankAccount().getPassword())) {
				System.out.println("Valid login");
				validLogin = true;
			}
		}
		
		return validLogin;
	}
	
	public boolean validWithdraw(SavingsAccount savings, float withdraw) {
		boolean valid = false;
		if (withdraw <= savings.getSavings()) {
			valid = true;
		}
		
		return valid;
	}
}
