package com.dollarsbank.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankApplication {

	public static void main(String[] args) {
		/* TODO
		 * 
		 *  Recent Transactions
		 *  -Store Transactions
		 *  -Print Transactions
		 *  
		 *  Password Validation
		 *  -Password contains the specified reqs: 8 characters with a Lowercase, an Uppercase, and a Special character
		 *  
		 *  User ID Validation
		 *  -Check that no User ID matches
		 *  
		 *  Withdrawal Validation
		 *  -Check that user is not withdrawing more than they have in savings.
		 *  
		 *  Input Validation in general - Making sure incorrect inputs are handled
		 *  -Letters for numbers mostly
		 *  
		*/
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
		
		DataGeneratorStubUtil.createAccount(customerTest);
		DataGeneratorStubUtil.createAccount(customerTest2);
		
		for(Customer cu: DataGeneratorStubUtil.customerList) {
			System.out.println(cu);
		}
		
		DollarsBankController.transferFunds(savingsTest, savingsTest2, 200.0f);
		
		for(Customer cu: DataGeneratorStubUtil.customerList) {
			System.out.println(cu);
		}
		
		DollarsBankController.transferFunds((SavingsAccount) customerTest.getBankAccount(), (SavingsAccount) customerTest2.getBankAccount(), 200.0f);
		
		for(Customer cu: DataGeneratorStubUtil.customerList) {
			System.out.println(cu);
		}
		
		boolean validLogin = appControl.validLogin("user3", "pass3");
		System.out.println(validLogin);
		
		Customer retrievedCustomer = appControl.retrieveCustomerFromAccount(savingsTest);
		System.out.println(retrievedCustomer);
		
	}
	
	public static void runMenu() {
		boolean loggedIn = false;
		
		Scanner scan = new Scanner(System.in);
		String menuInput = "";
		String nameInput = "";
		String addressInput = "";
		int contactNumInput = 0;
		String userInput = "";
		String passInput = "";
		float moneyInput = 0.0f;
		Account currentAccount = new Account();
//		Account currentAccount = new SavingsAccount();
//		SavingsAccount currentAccountAsSavings = (SavingsAccount) currentAccount;
//		SavingsAccount currentAccount = new SavingsAccount();
		
		while(true) {
			if (!loggedIn) {
				ConsolePrinterUtility.printWelcomeHeader();
				ConsolePrinterUtility.printWelcomeMenu();
				// Option 11: Welcome Menu Select
				ConsolePrinterUtility.printInputOption(11);
				menuInput = scan.next();
				switch (menuInput) {
				case "1":
					ConsolePrinterUtility.printCreateAccountHeader();
					
					// Option 0: Customer Name:
					ConsolePrinterUtility.printInputOption(0);
					
					ColorsUtility.startColorText(32);
					nameInput = scan.next();
					ColorsUtility.endColorText();
					
					// Option 1: Customer Address:
					ConsolePrinterUtility.printInputOption(1);
					
					ColorsUtility.startColorText(32);
					addressInput = scan.next();
					ColorsUtility.endColorText();
					
					// Option 2: Customer Contact Number:
					ConsolePrinterUtility.printInputOption(2);
					
					ColorsUtility.startColorText(32);
					contactNumInput = scan.nextInt();
					ColorsUtility.endColorText();
					
					// Option 3: User ID:
					ConsolePrinterUtility.printInputOption(3);
					
					ColorsUtility.startColorText(32);
					userInput = scan.next();
					ColorsUtility.endColorText();
					
					// Option 4: Password: 8 Characters with Lower, Upper, and Special
					ConsolePrinterUtility.printInputOption(4);
					
					ColorsUtility.startColorText(32);
					passInput = scan.next();
					ColorsUtility.endColorText();
					
					// Option 5: Initial Deposit Amount
					ConsolePrinterUtility.printInputOption(5);
					
					ColorsUtility.startColorText(32);
					moneyInput = scan.nextFloat();
					ColorsUtility.endColorText();
					
					DataGeneratorStubUtil.createAccount(nameInput, addressInput, contactNumInput, userInput, passInput, moneyInput);
					System.out.println(DataGeneratorStubUtil.customerList);
					break;
				case "2":
					ConsolePrinterUtility.printLogInHeader();
					
					// Option 3: User ID:
					ConsolePrinterUtility.printInputOption(3);
					
					ColorsUtility.startColorText(32);
					userInput = scan.next();
					ColorsUtility.endColorText();
					
					// Option 6: Password:
					ConsolePrinterUtility.printInputOption(6);
					
					ColorsUtility.startColorText(32);
					passInput = scan.next();
					ColorsUtility.endColorText();
					if(DollarsBankController.validLogin(userInput, passInput)) {
						currentAccount = DollarsBankController.retrieveAccountFromUserAndPass(userInput, passInput);
						loggedIn = true;
					} else {
						ConsolePrinterUtility.printInputErrorMessage(0);
					}
					break;
				case "3":
					ConsolePrinterUtility.printExitHeader();
					scan.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input, please enter a valid input");
					break;
				}
			} else {
				ConsolePrinterUtility.printSignedInHeader();
				ConsolePrinterUtility.printSignedInMenu();
				// Option 12: Signed In Menu Select
				ConsolePrinterUtility.printInputOption(12);
				menuInput = scan.next();
				switch (menuInput) {
				case "1":
					ConsolePrinterUtility.printDepositHeader();
					// Option 7: Enter Deposit Amount
					ConsolePrinterUtility.printInputOption(7);
					moneyInput = scan.nextFloat();
					DollarsBankController.depositAmount((SavingsAccount) currentAccount, moneyInput);
					break;
				case "2":
					ConsolePrinterUtility.printWithdrawHeader();
					// Option 8: Enter Withdraw Amount
					ConsolePrinterUtility.printInputOption(8);
					moneyInput = scan.nextFloat();
					if(DollarsBankController.validWithdraw((SavingsAccount) currentAccount, moneyInput)) {
						System.out.println("Valid withdraw");
						DollarsBankController.withdrawAmount((SavingsAccount) currentAccount, moneyInput);
					} else {
						ConsolePrinterUtility.printInputErrorMessage(5);
					}
					
					break;
				case "3":
					ConsolePrinterUtility.printFundTransferHeader();
					// Option 9: Enter User ID to Transfer to
					ConsolePrinterUtility.printInputOption(9);
					userInput = scan.next();
					// Option 10: Enter Transfer Amount
					ConsolePrinterUtility.printInputOption(10);
					moneyInput = scan.nextFloat();
					if(DollarsBankController.validWithdraw((SavingsAccount) currentAccount, moneyInput)) {
						System.out.println("Valid transfer");
						DollarsBankController.transferFunds((SavingsAccount) currentAccount, 
								(SavingsAccount) DollarsBankController.retrieveAccountFromUser(userInput), moneyInput);
					} else {
						ConsolePrinterUtility.printInputErrorMessage(5);
					}
					break;
				case "4":
					ConsolePrinterUtility.printRecentTransactionHeader();
					break;
				case "5":
					ConsolePrinterUtility.printCustomerInfoHeader();
					ConsolePrinterUtility.printCustomerInformation(DollarsBankController.retrieveCustomerFromAccount(currentAccount));
					break;
				case "6":
					loggedIn = false;
					break;
				case "7":
					System.out.println(currentAccount);
//					System.out.println("Balance:" + ((SavingsAccount) currentAccount).getSavings());
					break;
				default:
					System.out.println("Invalid input, please enter a valid input");
					break;
				}
				
			}
			
		}
		
	}

}
