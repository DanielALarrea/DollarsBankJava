package com.dollarsbank.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runTests();
		runMenu();
	}
	
	public static void runTests() {
		DollarsBankController appControl = new DollarsBankController();
		
		LocalDateTime localTime = LocalDateTime.now();
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = localTime.format(formatTime);
		System.out.println(localTime);
		System.out.println(formattedDate);
		
		SavingsAccount savingsTest = new SavingsAccount("user", "pass", 5000);
		Customer customerTest = new Customer("Dan", "Place Street", 123, savingsTest);
		SavingsAccount savingsTest2 = new SavingsAccount("user2", "pass2", 2000);
		Customer customerTest2 = new Customer("Dan2", "Place Street2", 1232, savingsTest2);
		System.out.println(savingsTest);
		System.out.println(customerTest.getBankAccount().toString());
		
		savingsTest.deposit(1200.0f);
		System.out.println(savingsTest);
		System.out.println(customerTest.getBankAccount().toString());
		
		System.out.println(savingsTest);
		System.out.println(savingsTest2);
		DollarsBankController.transferFunds(savingsTest, savingsTest2, 200.0f);
		System.out.println(savingsTest);
		System.out.println(savingsTest2);
		System.out.println(customerTest.getBankAccount().toString());
		System.out.println(customerTest2.getBankAccount().toString());
		
		DataGeneratorStubUtil data = new DataGeneratorStubUtil();
//		data.createAccount(customerTest.getName(), customerTest.getAddress(), customerTest.getContactNum(), 
//				savingsTest.getUserId(), savingsTest.getPassword(), savingsTest.getSavings());
//		data.createAccount(customerTest2.getName(), customerTest2.getAddress(), customerTest2.getContactNum(), 
//				savingsTest2.getUserId(), savingsTest2.getPassword(), savingsTest2.getSavings());
		
		data.createAccount(customerTest);
		data.createAccount(customerTest2);
		
		for(Customer cu: data.customerList) {
			System.out.println(cu);
		}
		
		DollarsBankController.transferFunds(savingsTest, savingsTest2, 200.0f);
		
		for(Customer cu: data.customerList) {
			System.out.println(cu);
		}
		
		DollarsBankController.transferFunds((SavingsAccount) customerTest.getBankAccount(), (SavingsAccount) customerTest2.getBankAccount(), 200.0f);
		
		for(Customer cu: data.customerList) {
			System.out.println(cu);
		}
		
		boolean validLogin = appControl.validLogin("user3", "pass3", data);
		System.out.println(validLogin);
		
		Customer retrievedCustomer = appControl.retrieveCustomerFromAccount(savingsTest, data);
		System.out.println(retrievedCustomer);
		
	}
	
	public static void runMenu() {
		DataGeneratorStubUtil data = new DataGeneratorStubUtil();
		ConsolePrinterUtility console = new ConsolePrinterUtility();
		DollarsBankController control = new DollarsBankController();
		boolean loggedIn = false;
		
		Scanner scan = new Scanner(System.in);
		String menuInput = "";
		String nameInput = "";
		String addressInput = "";
		int contactNumInput = 0;
		String userInput = "";
		String passInput = "";
		float moneyInput = 0.0f;
		SavingsAccount currentAccount = null;
		
		while(true) {
			if (!loggedIn) {
				console.printWelcomeHeader();
				console.printWelcomeMenu();
				menuInput = scan.next();
				switch (menuInput) {
				case "1":
					console.printCreateAccountHeader();
					System.out.println("Customer Name:");
					nameInput = scan.next();
					System.out.println("Customer Address:");
					addressInput = scan.next();
					System.out.println("Customer Contact Number:");
					contactNumInput = scan.nextInt();
					System.out.println("User ID:");
					userInput = scan.next();
					System.out.println("Password: 8 Characters with Lower, Upper, and Special");
					passInput = scan.next();
					System.out.println("Initial Deposit Amount");
					moneyInput = scan.nextFloat();
					data.createAccount(nameInput, addressInput, contactNumInput, userInput, passInput, moneyInput);
					System.out.println(data.customerList);
					break;
				case "2":
					console.printLogInHeader();
					System.out.println("User ID:");
					userInput = scan.next();
					System.out.println("Password:");
					passInput = scan.next();
					if(control.validLogin(userInput, passInput, data)) {
						//currentAccount = control.retrieveAccountFromUserAndPass(userInput, passInput, data);
						loggedIn = true;
					} else {
						System.out.println("Invalid login. Try again");
					}
					break;
				case "3":
					System.out.println("Exiting menu...");
					scan.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input, please enter a valid input");
					break;
				}
			} else {
				console.printSignedInHeader();
				console.printSignedInMenu();
				menuInput = scan.next();
				switch (menuInput) {
				case "1":
					console.printDepositHeader();
					System.out.println("Enter an amount to deposit:");
					moneyInput = scan.nextFloat();
					DollarsBankController.depositAmount(currentAccount, moneyInput);
					break;
				case "2":
					console.printWithdrawHeader();
					break;
				case "3":
					console.printFundTransferHeader();
					break;
				case "4":
					console.printRecentTransactionHeader();
					break;
				case "5":
					console.printCustomerInfoHeader();
					break;
				case "6":
					loggedIn = false;
					break;
				case "7":
					System.out.println("Balance:" + currentAccount.getSavings());
					break;
				default:
					System.out.println("Invalid input, please enter a valid input");
					break;
				}
				
			}
			
		}
		
	}

}
