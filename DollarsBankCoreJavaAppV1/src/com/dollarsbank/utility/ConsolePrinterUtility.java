package com.dollarsbank.utility;

import java.time.LocalDateTime;

import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class ConsolePrinterUtility {
	
	public void printWelcomeHeader() {
		System.out.println("+---------------------------+");
		System.out.println("| DOLLARSBANK Welcomes You! |");
		System.out.println("+---------------------------+");
	}
	
	public void printSignedInHeader() {
		System.out.println("+---------------------+");
		System.out.println("| WELCOME Customer!!! |");
		System.out.println("+---------------------+");
	}
	
	public void printCreateAccountHeader() {
		System.out.println("+-------------------------------+");
		System.out.println("| Enter Details For New Account |");
		System.out.println("+-------------------------------+");
	}
	
	public void printLogInHeader() {
		System.out.println("+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+");
	}
	
	public void printDepositHeader() {
		System.out.println("+--------------------+");
		System.out.println("| Deposit To Account |");
		System.out.println("+--------------------+");
	}
	
	public void printWithdrawHeader() {
		System.out.println("+-----------------------+");
		System.out.println("| Withdraw From Account |");
		System.out.println("+-----------------------+");
	}
	
	public void printFundTransferHeader() {
		System.out.println("+----------------+");
		System.out.println("| Transfer Funds |");
		System.out.println("+----------------+");
	}

	public void printRecentTransactionHeader() {
		System.out.println("+------------------------+");
		System.out.println("| 5 Recent Transactions: |");
		System.out.println("+------------------------+");
	}
	
	public void printCustomerInfoHeader() {
		System.out.println("+-----------------------+");
		System.out.println("| Customer Information: |");
		System.out.println("+-----------------------+");
	}
	
	public void printWelcomeMenu() {
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
	public void printSignedInMenu() {
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");
	}
	
	public String printCurrentBalanceAndTime(SavingsAccount savings) {
		return "Balance - " + savings.getSavings() + " as of " + LocalDateTime.now();
	}
	
	public String printDepositTransaction(int deposit) {
		return "Deposited " + deposit;
	}
	
	public String printWithdrawTransaction(int withdraw) {
		return "Withdrew " + withdraw;
	}
	
	public String printTransferTransaction(int transfer, String user1, String user2) {
		return "User " + user1 + " transfered " + transfer + " to User " + user2;
	}
	
	public void printCustomerInformation(Customer placeholder) {
		// Look into this later, and do it properly
		SavingsAccount savingsAcc = (SavingsAccount) placeholder.getBankAccount();
		System.out.println("Name: " + placeholder.getName());
		System.out.println("Address: " + placeholder.getAddress());
		System.out.println("Contact Number: " + placeholder.getContactNum());
		System.out.println("User ID: " + placeholder.getBankAccount().getUserId());
		System.out.println("Balance: " + savingsAcc.getSavings());
	}
}
