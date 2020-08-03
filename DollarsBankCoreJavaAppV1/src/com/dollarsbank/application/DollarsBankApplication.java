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
		 *  Input Validation in general - Making sure incorrect inputs are handled
		 *  -Letters for numbers mostly
		 *  
		 *  Transfer Funds User validation
		 *  -Check that User ID is distinct as well
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
		//SavingsAccount currentAccountAsSavings = (SavingsAccount) currentAccount;
		SavingsAccount otherAccount = new SavingsAccount();
		SavingsAccount newSavings = new SavingsAccount();
		String transaction = "";
		
		Customer testCustomer = new Customer("Name", "Address", 1234567890, new SavingsAccount("U01", "Pass", 500));
		DataGeneratorStubUtil.createAccount(testCustomer);
		
		Customer testCustomer2 = new Customer("Name", "Address", 1234567890, new SavingsAccount("U02", "Pass2", 300));
		DataGeneratorStubUtil.createAccount(testCustomer2);
		
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
					if (!DollarsBankController.uniqueUserId(userInput)) {
						// Error 1: Non-unique UserID
						ConsolePrinterUtility.printInputErrorMessage(1);
					} else if (!DollarsBankController.matchesPasswordCriteria(passInput)) {
						// Error 2: Password does not fit criteria
						ConsolePrinterUtility.printInputErrorMessage(2);
					} else {
						newSavings = new SavingsAccount(userInput, passInput, moneyInput);
						transaction = ConsolePrinterUtility.printAccountCreation(newSavings.getUserId()) + "\n"
									+ ConsolePrinterUtility.printCurrentBalanceAndTime(newSavings);
						DollarsBankController.pushTransaction(newSavings, transaction);
						DataGeneratorStubUtil.createAccount(nameInput, addressInput, contactNumInput, newSavings);
					}
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
						// Error 0: Invalid credentials
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
					transaction = ConsolePrinterUtility.printDepositTransaction(moneyInput) + "\n" 
								+ ConsolePrinterUtility.printCurrentBalanceAndTime((SavingsAccount) currentAccount);
					DollarsBankController.pushTransaction((SavingsAccount) currentAccount, transaction);
					break;
				case "2":
					ConsolePrinterUtility.printWithdrawHeader();
					// Option 8: Enter Withdraw Amount
					ConsolePrinterUtility.printInputOption(8);
					moneyInput = scan.nextFloat();
					if(DollarsBankController.validWithdraw((SavingsAccount) currentAccount, moneyInput)) {
						System.out.println("Valid withdraw");
						DollarsBankController.withdrawAmount((SavingsAccount) currentAccount, moneyInput);
						transaction = ConsolePrinterUtility.printWithdrawTransaction(moneyInput) + "\n" 
								+ ConsolePrinterUtility.printCurrentBalanceAndTime((SavingsAccount) currentAccount);
						DollarsBankController.pushTransaction((SavingsAccount) currentAccount, transaction);
					} else {
						// Error 5: Not Enough Funds
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
					if(DollarsBankController.userExists(userInput)) {
						if(DollarsBankController.validWithdraw((SavingsAccount) currentAccount, moneyInput)) {
							otherAccount = (SavingsAccount) DollarsBankController.retrieveAccountFromUser(userInput);
							System.out.println("Valid transfer");
							DollarsBankController.transferFunds((SavingsAccount) currentAccount, otherAccount, moneyInput);

							transaction = ConsolePrinterUtility.printGiveTransferTransaction(moneyInput, currentAccount.getUserId(), otherAccount.getUserId()) + "\n" 
									+ ConsolePrinterUtility.printCurrentBalanceAndTime((SavingsAccount) currentAccount);
							DollarsBankController.pushTransaction((SavingsAccount) currentAccount, transaction);

							transaction = ConsolePrinterUtility.printReceiveTransferTransaction(moneyInput, otherAccount.getUserId(), currentAccount.getUserId()) + "\n" 
									+ ConsolePrinterUtility.printCurrentBalanceAndTime(otherAccount);
							DollarsBankController.pushTransaction(otherAccount, transaction);
						} else {
							// Error 5: Not Enough Funds
							ConsolePrinterUtility.printInputErrorMessage(5);
						}
						
					} else {
						// Error 6: User does not exist
						ConsolePrinterUtility.printInputErrorMessage(6);
					}
					break;
				case "4":
					ConsolePrinterUtility.printRecentTransactionHeader();
					ConsolePrinterUtility.printRecentTransactions((SavingsAccount) currentAccount);
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
