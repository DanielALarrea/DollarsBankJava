package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankApplication {

	public static void main(String[] args) {
		runMenu();
	}
		
	public static void runMenu() {
		// Display either the initial menu or logged in menu
		boolean loggedIn = false;
		
		Scanner scan = new Scanner(System.in);
		
		// Receive input for menu option
		String menuInput = "";
		
		// Customer name for account creation
		String nameInput = "";
		
		// Customer address for account creation
		String addressInput = "";
		
		// Customer contact number for account creation
		String contactNumInput = "";
		// Contact number converted to specific format
		String contactNumConvert = "";
		
		// User ID, for account creation or logging in
		String userInput = "";
		// Password, for account creation or logging in
		String passInput = "";
		
		// Used for initial deposit, standard deposit, withdraw, and transfer
		// Initially a string to check that it is a number, than converted to a float
		String moneyInputAsString = "";
		float moneyInput = 0.0f;
		
		// The current account that is logged in
		Account currentAccount = new Account();
		
		// The other account being transferred funds to
		SavingsAccount otherAccount = new SavingsAccount();
		
		// Savings account created before account registration
		// Used to perform some actions before storing
		SavingsAccount newSavings = new SavingsAccount();
		
		// Store a recording of a transaction(deposit, withdraw, etc)
		String transaction = "";
		
		// Two accounts for testing right away
		// Customer 1 User ID is U01 and password is Pa$$word, begins with 500
		// Customer 2 User ID is U02 and password is P@ssword, begins with 300
		DataGeneratorStubUtil.initializeTestAccounts();
		
		while(true) {
			// Menu and options when user is not logged in
			if (!loggedIn) {
				ConsolePrinterUtility.printWelcomeHeader();
				ConsolePrinterUtility.printWelcomeMenu();
				// Option 11: Welcome Menu Select
				ConsolePrinterUtility.printInputOption(11);
				menuInput = scan.nextLine();
				switch (menuInput) {
				// Menu option 1: Account creation
				case "1":
					ConsolePrinterUtility.printCreateAccountHeader();
					
					// Option 0: Customer Name:
					ConsolePrinterUtility.printInputOption(0);
					
					ColorsUtility.startColorText(32);
					nameInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					// Option 1: Customer Address:
					ConsolePrinterUtility.printInputOption(1);
					
					ColorsUtility.startColorText(32);
					addressInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					// Option 2: Customer Contact Number:
					ConsolePrinterUtility.printInputOption(2);
					
					ColorsUtility.startColorText(32);
					contactNumInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					// Option 3: User ID:
					ConsolePrinterUtility.printInputOption(3);
					
					ColorsUtility.startColorText(32);
					userInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					// Option 4: Password: 8 Characters with Lower, Upper, and Special
					ConsolePrinterUtility.printInputOption(4);
					
					ColorsUtility.startColorText(32);
					passInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					// Option 5: Initial Deposit Amount
					ConsolePrinterUtility.printInputOption(5);
					
					ColorsUtility.startColorText(32);
					moneyInputAsString = scan.nextLine();
					ColorsUtility.endColorText();
						
					if (DollarsBankController.isFloat(moneyInputAsString)) {
						moneyInput = Float.parseFloat(moneyInputAsString);
						if (!DollarsBankController.validPhoneNum(contactNumInput)) {
							// Error 8: Invalid contact number
							ConsolePrinterUtility.printInputErrorMessage(8);
						} else if (!DollarsBankController.uniqueUserId(userInput)) {
							// Error 1: Non-unique UserID
							ConsolePrinterUtility.printInputErrorMessage(1);
						} else if (!DollarsBankController.matchesPasswordCriteria(passInput)) {
							// Error 2: Password does not fit criteria
							ConsolePrinterUtility.printInputErrorMessage(2);
						} else if (moneyInput < 0) {
							// Error 4: Incorrect/negative number input
							ConsolePrinterUtility.printInputErrorMessage(4);
						} else {
							contactNumConvert = DollarsBankController.convertPhoneForm(contactNumInput);
							newSavings = new SavingsAccount(userInput, passInput, moneyInput);
							transaction = ConsolePrinterUtility.printAccountCreation(newSavings.getUserId()) + "\n"
									+ ConsolePrinterUtility.printCurrentBalanceAndTime(newSavings);
							DollarsBankController.pushTransaction(newSavings, transaction);
							DataGeneratorStubUtil.createAccount(nameInput, addressInput, contactNumConvert, newSavings);
							// Success 0: Account Creation Complete
							ConsolePrinterUtility.printSuccessMessage(0);
						}
					} else {
						// Error 4: Incorrect/negative number input
						ConsolePrinterUtility.printInputErrorMessage(4);
					}
					break;
				// Menu option 2: Log in
				case "2":
					ConsolePrinterUtility.printLogInHeader();
					
					// Option 3: User ID:
					ConsolePrinterUtility.printInputOption(3);
					
					ColorsUtility.startColorText(32);
					userInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					// Option 6: Password:
					ConsolePrinterUtility.printInputOption(6);
					
					ColorsUtility.startColorText(32);
					passInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					if(DollarsBankController.validLogin(userInput, passInput)) {
						currentAccount = DollarsBankController.retrieveAccountFromUserAndPass(userInput, passInput);
						loggedIn = true;
						// Success 1: Log In Complete
						ConsolePrinterUtility.printSuccessMessage(1);
					} else {
						// Error 0: Invalid credentials
						ConsolePrinterUtility.printInputErrorMessage(0);
					}
					break;
				// Menu option 3: Exit application
				case "3":
					ConsolePrinterUtility.printExitHeader();
					scan.close();
					System.exit(0);
					break;
				// Incorrect menu input
				default:
					// Error 9: Invalid menu input
					ConsolePrinterUtility.printInputErrorMessage(9);
					break;
				}
			// Menu and options when user is logged in
			} else {
				ConsolePrinterUtility.printSignedInHeader();
				ConsolePrinterUtility.printSignedInMenu();
				// Option 12: Signed In Menu Select
				ConsolePrinterUtility.printInputOption(12);
				menuInput = scan.nextLine();
				switch (menuInput) {
				// Menu option 1: Deposit funds to account
				case "1":
					ConsolePrinterUtility.printDepositHeader();
					// Option 7: Enter Deposit Amount
					ConsolePrinterUtility.printInputOption(7);
					
					ColorsUtility.startColorText(32);
					moneyInputAsString = scan.nextLine();
					ColorsUtility.endColorText();
					if(DollarsBankController.isFloat(moneyInputAsString)) {
						moneyInput = Float.parseFloat(moneyInputAsString);
						if (moneyInput > 0) {
							DollarsBankController.depositAmount((SavingsAccount) currentAccount, moneyInput);
							transaction = ConsolePrinterUtility.printDepositTransaction(moneyInput) + "\n" 
									+ ConsolePrinterUtility.printCurrentBalanceAndTime((SavingsAccount) currentAccount);
							DollarsBankController.pushTransaction((SavingsAccount) currentAccount, transaction);
							
							// Success 2: Deposit complete
							ConsolePrinterUtility.printSuccessMessage(2);
						} else {
							// Error 4: Incorrect/negative number input
							ConsolePrinterUtility.printInputErrorMessage(4);
						}
					} else {
						// Error 4: Incorrect/negative number input
						ConsolePrinterUtility.printInputErrorMessage(4);
					}
					break;
				// Menu option 2: Withdraw funds from account
				case "2":
					ConsolePrinterUtility.printWithdrawHeader();
					// Option 8: Enter Withdraw Amount
					ConsolePrinterUtility.printInputOption(8);
					
					ColorsUtility.startColorText(32);
					moneyInputAsString = scan.nextLine();
					ColorsUtility.endColorText();
					
					if(DollarsBankController.isFloat(moneyInputAsString)) {
						moneyInput = Float.parseFloat(moneyInputAsString);
						if (moneyInput > 0) {
							if(DollarsBankController.validWithdraw((SavingsAccount) currentAccount, moneyInput)) {
								DollarsBankController.withdrawAmount((SavingsAccount) currentAccount, moneyInput);
								transaction = ConsolePrinterUtility.printWithdrawTransaction(moneyInput) + "\n" 
										+ ConsolePrinterUtility.printCurrentBalanceAndTime((SavingsAccount) currentAccount);
								DollarsBankController.pushTransaction((SavingsAccount) currentAccount, transaction);
								
								// Success 3: Withdraw Complete
								ConsolePrinterUtility.printSuccessMessage(3);
							} else {
								// Error 5: Not Enough Funds
								ConsolePrinterUtility.printInputErrorMessage(5);
							}
						} else {
							// Error 4: Incorrect/negative number input
							ConsolePrinterUtility.printInputErrorMessage(4);
						}
					} else {
						// Error 4: Incorrect/negative number input
						ConsolePrinterUtility.printInputErrorMessage(4);
					}
					break;
				// Menu option 3: Transfer funds from one account to another
				case "3":
					ConsolePrinterUtility.printFundTransferHeader();
					// Option 9: Enter User ID to Transfer to
					ConsolePrinterUtility.printInputOption(9);
					
					ColorsUtility.startColorText(32);
					userInput = scan.nextLine();
					ColorsUtility.endColorText();
					
					// Option 10: Enter Transfer Amount
					ConsolePrinterUtility.printInputOption(10);
					
					ColorsUtility.startColorText(32);
					moneyInputAsString = scan.nextLine();
					ColorsUtility.endColorText();
					
					if(DollarsBankController.userExists(userInput)) {
						if(!userInput.equals(currentAccount.getUserId())) {
							if(DollarsBankController.isFloat(moneyInputAsString)) {
								moneyInput = Float.parseFloat(moneyInputAsString);
								if (moneyInput > 0) {
									if(DollarsBankController.validWithdraw((SavingsAccount) currentAccount, moneyInput)) {
										otherAccount = (SavingsAccount) DollarsBankController.retrieveAccountFromUser(userInput);
										DollarsBankController.transferFunds((SavingsAccount) currentAccount, otherAccount, moneyInput);

										transaction = ConsolePrinterUtility.printGiveTransferTransaction(moneyInput, currentAccount.getUserId(), otherAccount.getUserId()) + "\n" 
												+ ConsolePrinterUtility.printCurrentBalanceAndTime((SavingsAccount) currentAccount);
										DollarsBankController.pushTransaction((SavingsAccount) currentAccount, transaction);

										transaction = ConsolePrinterUtility.printReceiveTransferTransaction(moneyInput, otherAccount.getUserId(), currentAccount.getUserId()) + "\n" 
												+ ConsolePrinterUtility.printCurrentBalanceAndTime(otherAccount);
										DollarsBankController.pushTransaction(otherAccount, transaction);
										
										// Success 4: Fund Transfer Complete
										ConsolePrinterUtility.printSuccessMessage(4);
									} else {
										// Error 5: Not Enough Funds
										ConsolePrinterUtility.printInputErrorMessage(5);
									}
								} else {
									// Error 4: Incorrect/negative number input
									ConsolePrinterUtility.printInputErrorMessage(4);
								}
							} else {
								// Error 4: Incorrect/negative number input
								ConsolePrinterUtility.printInputErrorMessage(4);
							}
						} else {
							// Error 7: User is attempting to transfer to themself
							ConsolePrinterUtility.printInputErrorMessage(7);
						}
					} else {
						// Error 6: User does not exist
						ConsolePrinterUtility.printInputErrorMessage(6);
					}
					break;
				// Menu option 4: Display 5 most recent transactions of account
				case "4":
					ConsolePrinterUtility.printRecentTransactionHeader();
					ConsolePrinterUtility.printRecentTransactions((SavingsAccount) currentAccount);
					break;
				// Menu option 5: Display customer information
				case "5":
					ConsolePrinterUtility.printCustomerInfoHeader();
					ConsolePrinterUtility.printCustomerInformation(DollarsBankController.retrieveCustomerFromAccount(currentAccount));
					break;
				// Menu option 6: Sign out and return to first menu
				case "6":
					loggedIn = false;
					break;
				// Incorrect menu input
				default:
					// Error 9: Invalid menu input
					ConsolePrinterUtility.printInputErrorMessage(9);
					break;
				}	
			}	
		}
	}
}
