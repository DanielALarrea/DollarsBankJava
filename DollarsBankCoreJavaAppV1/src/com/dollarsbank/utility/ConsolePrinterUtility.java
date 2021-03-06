package com.dollarsbank.utility;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class ConsolePrinterUtility {
	
	// Print the header for the initial screen
	public static void printWelcomeHeader() {
		ColorsUtility.printBlue("+---------------------------+");
		ColorsUtility.printBlue("| DOLLARSBANK Welcomes You! |");
		ColorsUtility.printBlue("+---------------------------+");
	}
	
	// Print the header for the signed in menu
	public static void printSignedInHeader() {
		ColorsUtility.printBlue("+---------------------+");
		ColorsUtility.printBlue("| WELCOME Customer!!! |");
		ColorsUtility.printBlue("+---------------------+");
	}
	
	// Print the header for creating an account
	public static void printCreateAccountHeader() {
		ColorsUtility.printBlue("+-------------------------------+");
		ColorsUtility.printBlue("| Enter Details For New Account |");
		ColorsUtility.printBlue("+-------------------------------+");
	}
	
	// Print the header for customer log in
	public static void printLogInHeader() {
		ColorsUtility.printBlue("+---------------------+");
		ColorsUtility.printBlue("| Enter Login Details |");
		ColorsUtility.printBlue("+---------------------+");
	}
	
	// Print the header for the deposit transaction
	public static void printDepositHeader() {
		ColorsUtility.printBlue("+--------------------+");
		ColorsUtility.printBlue("| Deposit To Account |");
		ColorsUtility.printBlue("+--------------------+");
	}
	
	// Print the header for the withdraw transaction
	public static void printWithdrawHeader() {
		ColorsUtility.printBlue("+-----------------------+");
		ColorsUtility.printBlue("| Withdraw From Account |");
		ColorsUtility.printBlue("+-----------------------+");
	}
	
	// Print the header for the funds transfer transaction
	public static void printFundTransferHeader() {
		ColorsUtility.printBlue("+----------------+");
		ColorsUtility.printBlue("| Transfer Funds |");
		ColorsUtility.printBlue("+----------------+");
	}

	// Print the header for the 5 recent transaction
	public static void printRecentTransactionHeader() {
		ColorsUtility.printBlue("+------------------------+");
		ColorsUtility.printBlue("| 5 Recent Transactions: |");
		ColorsUtility.printBlue("+------------------------+");
	}
	
	// Print the header for displaying customer information
	public static void printCustomerInfoHeader() {
		ColorsUtility.printBlue("+-----------------------+");
		ColorsUtility.printBlue("| Customer Information: |");
		ColorsUtility.printBlue("+-----------------------+");
	}
	
	// Print the header for exiting the program
	public static void printExitHeader() {
		ColorsUtility.printBlue("+----------------------------------+");
		ColorsUtility.printBlue("| Thank You For Using DOLLARSBANK! |");
		ColorsUtility.printBlue("+----------------------------------+");
	}
	
	// Print the menu options for the initial menu
	public static void printWelcomeMenu() {
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
	// Print the menu options for the signed in menu
	public static void printSignedInMenu() {
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");
	}
	
	// Display an input message
	public static void printInputOption(int option) {
		switch(option) {
		case 0:
			System.out.println("Customer Name:");
			break;
		case 1:
			System.out.println("Customer Address:");
			break;
		case 2:
			System.out.println("Customer Contact Number:");
			break;
		case 3:
			System.out.println("User ID:");
			break;
		case 4:
			System.out.println("Password: 8 Characters with Lower, Upper, and Special");
			break;
		case 5:
			System.out.println("Initial Deposit:");
			break;
		case 6:
			System.out.println("Password:");
			break;
		case 7:
			System.out.println("Enter Deposit Amount:");
			break;
		case 8:
			System.out.println("Enter Withdraw Amount:");
			break;
		case 9:
			System.out.println("Enter User ID of Account to Transfer to:");
			break;
		case 10:
			System.out.println("Enter Transfer Amount:");
			break;
		case 11:
			System.out.println();
			ColorsUtility.printGreen("Enter Choice (1, 2, 3) :");
			break;
		case 12:
			System.out.println();
			ColorsUtility.printGreen("Enter Choice (1, 2, 3, 4, 5, 6) :");
			break;
		}
	}
	
	// Display an error message when the customer has given some incorrect input
	public static void printInputErrorMessage(int option) {
		switch(option) {
		case 0:
			// When user is logging in and the user ID and password don't match existing ones
			ColorsUtility.printRed("Invalid Credentials. Please Try Again!");
			break;
		case 1:
			// When user is creating account and tries to give user ID that exists
			ColorsUtility.printRed("That User ID already exists. Please enter a unique ID!");
			break;
		case 2:
			// When user is creating account and does not make a password that follows the given criteria(8 chars, Lower, Upper, Special)
			ColorsUtility.printRed("That Password does not fit the criteria. Please ensure the criteria are met!");
			break;
		case 3:
			// When user is creating account and tries to enter a negative value for the initial deposit
			ColorsUtility.printRed("You cannot create an account with a negative balance. Please enter a positive number!");
			break;
		case 4:
			// When user attempts to enter non-numbers into number only inputs, such as Deposit or Withdraw, or enters a negative number value
			ColorsUtility.printRed("Invalid input. Please enter postive number values only!");
			break;
		case 5:
			// When user attempts to withdraw/transfer more money than they have
			ColorsUtility.printRed("You do not have enough in your balance to perform this transaction");
			break;
		case 6:
			// When user attempts to transfer to account that doesn't exist
			ColorsUtility.printRed("User not found. Please ensure the user is correct!");
			break;
		case 7:
			// When user attempts to transfer to themselves
			ColorsUtility.printRed("You cannot transfer funds to yourself");
			break;
		case 8:
			// When user is creating account and does not give a proper contact number
			ColorsUtility.printRed("Invalid contact number");
			break;
		case 9:
			// When user does not give desired menu input
			ColorsUtility.printRed("Invalid input, please enter a valid input");
			break;
		}
	}
	
	public static void printSuccessMessage(int option) {
		switch(option) {
		case 0:
			// Successful account creation
			ColorsUtility.printYellow("Account creation successful");
			break;
		case 1:
			// Successful log in
			ColorsUtility.printYellow("Log in successful");
			break;
		case 2:
			// Successful deposit
			ColorsUtility.printYellow("Funds deposited");
			break;
		case 3:
			// Successful withdraw
			ColorsUtility.printYellow("Funds withdrawn");
			break;
		case 4:
			// Successful transfer
			ColorsUtility.printYellow("Funds transferred");
			break;
		}
	}
	
	// Added to every transaction
	public static String printCurrentBalanceAndTime(SavingsAccount savings) {
		DateTimeFormatter dateFormat = DateTimeFormatter.RFC_1123_DATE_TIME;
		ZonedDateTime timeOfTransaction = ZonedDateTime.now();
		String formattedDateTime = timeOfTransaction.format(dateFormat);
		return "Balance - " + ColorsUtility.turnGreen(Float.toString(savings.getSavings())) + " as of " + ColorsUtility.turnYellow(formattedDateTime);
	}
	
	// Record deposit transaction
	public static String printDepositTransaction(float deposit) {
		return "Deposited " +  ColorsUtility.turnGreen(Float.toString(deposit));
	}
	
	// Record withdraw transaction
	public static String printWithdrawTransaction(float withdraw) {
		return "Withdrew " +  ColorsUtility.turnGreen(Float.toString(withdraw));
	}
	
	// Record account creation
	public static String printAccountCreation(String userId) {
		return "Account creation for account " + ColorsUtility.turnYellow("[" + userId + "]");
	}
	
	// Record user1 transferring funds to user2
	public static String printGiveTransferTransaction(float transfer, String user1, String user2) {
		return "User " + ColorsUtility.turnYellow("[" + user1 + "]")
			+ " transferred " + ColorsUtility.turnGreen(Float.toString(transfer))
			+ " to User " + ColorsUtility.turnYellow("[" + user2 + "]");
	}
	
	// Record user1 receiving funds from user2
	public static String printReceiveTransferTransaction(float transfer, String user1, String user2) {
		return "User " + ColorsUtility.turnYellow("[" + user1 + "]")
			+ " receieved " + ColorsUtility.turnGreen(Float.toString(transfer)) 
			+ " from User " + ColorsUtility.turnYellow("[" + user2 + "]");
	}
	
	// Print customer information(not password of course)
	public static void printCustomerInformation(Customer customer) {
		SavingsAccount savingsAcc = (SavingsAccount) customer.getBankAccount();
		System.out.println("Name: " + ColorsUtility.turnGreen(customer.getName()));
		System.out.println("Address: " + ColorsUtility.turnGreen(customer.getAddress()));
		System.out.println("Contact Number: " + ColorsUtility.turnGreen(customer.getContactNum()));
		System.out.println("User ID: " + ColorsUtility.turnGreen(savingsAcc.getUserId()));
		System.out.println("Balance: " + ColorsUtility.turnGreen(Float.toString(savingsAcc.getSavings())));
	}
	
	// Print an Account's recent transactions
	public static void printRecentTransactions(SavingsAccount savings) {
		for(String transaction: savings.xMostRecentTransaction(5)) {
			System.out.println(transaction);
		}
	}
}
