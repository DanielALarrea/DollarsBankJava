package com.dollarsbank.controller;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankController {
	
	// Deposit savings to account
	public static void depositAmount(SavingsAccount savings, float deposit) {
		savings.deposit(deposit);
	}
	
	// Withdraw savings from account
	public static void withdrawAmount(SavingsAccount savings, float withdraw) {
		savings.withdraw(withdraw);
	}
	
	// Transfer funds from one account to another
	public static void transferFunds(SavingsAccount savingsFrom, SavingsAccount savingsTo, float amount) {
		savingsFrom.withdraw(amount);
		savingsTo.deposit(amount);
	}
	
	public static void pushTransaction(SavingsAccount savings, String transaction) {
		savings.pushRecentTransaction(transaction);
	}
	
	// Retrieve the customer associated with an Account
	public static Customer retrieveCustomerFromAccount(Account account) {
		Customer customer = new Customer();
		for (Customer cu: DataGeneratorStubUtil.customerList) {
			if (cu.getBankAccount() == account) {
				customer = cu;
			}
		}
		
		return customer;
	}
	
	// Retrieve the Account associated with a particular userID and password
	public static Account retrieveAccountFromUserAndPass(String user, String pass) {
		Account account = new Account();
		for (Customer cu: DataGeneratorStubUtil.customerList) {
			if (user.equals(cu.getBankAccount().getUserId()) && pass.equals(cu.getBankAccount().getPassword())) {	
				account = cu.getBankAccount();
			}
		}
		
		return account;
	}
	
	// With only the userID, retrieve the Account associated with it
	public static Account retrieveAccountFromUser(String user) {
		Account account = new Account();
		for (Customer cu: DataGeneratorStubUtil.customerList) {
			if (user.equals(cu.getBankAccount().getUserId())) {	
				account = cu.getBankAccount();
			}
		}
		
		return account;
	}
	
	public static boolean userExists(String user) {
		boolean exists = true;
		Account userAccount = new Account();
		if (DollarsBankController.retrieveAccountFromUser(user).getUserId() == null) {
			exists = false;
		}
		return exists;
	}
	
	// Ensure the customer's userID is unique to them
	public static boolean uniqueUserId(String user) {
		boolean isUnique = true;
		for (Customer cu: DataGeneratorStubUtil.customerList) {
			if (user.equals(cu.getBankAccount().getUserId())) {	
				isUnique = false;
			}
		}
		
		return isUnique;
	}
	
	// Criteria: At least 8 characters in length, 1 Lowercase character, 1 Uppercase character, 1 Special character
	public static boolean matchesPasswordCriteria(String password) {
		boolean matchesCriteria = true;
		if (password.length() != 8 
		|| password.equals(password.toLowerCase()) 
		|| password.equals(password.toUpperCase()) 
		|| password.matches("[A-Za-z0-9 ]*")) {
			matchesCriteria = false;
		}
		
		return matchesCriteria;
	}
	
	// Check that the customer's user and password are in the database
	public static boolean validLogin(String user, String pass) {
		boolean validLogin = false;
		for (Customer cu: DataGeneratorStubUtil.customerList) {
			if (user.equals(cu.getBankAccount().getUserId()) && pass.equals(cu.getBankAccount().getPassword())) {
				System.out.println("Valid login");
				validLogin = true;
			}
		}
		
		return validLogin;
	}
	
	// Check that the customer is not trying to withdraw more than they have
	public static boolean validWithdraw(SavingsAccount savings, float withdraw) {
		boolean valid = false;
		if (withdraw <= savings.getSavings()) {
			valid = true;
		}
		
		return valid;
	}

}
