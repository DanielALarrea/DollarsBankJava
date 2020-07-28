package com.dollarsbank.model;

import java.util.List;

public class SavingsAccount extends Account {
	
	private int savings;
	private List<String> recentTransactions;

	public SavingsAccount(String userId, String password, int savings) {
		super(userId, password);
		this.savings = savings;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}
	
	public List<String> getRecentTransactions() {
		return recentTransactions;
	}
	
	public void setRecentTransactions(List<String> recentTransactions) {
		this.recentTransactions = recentTransactions;
	}
	
	public void deposit(int deposit) {
		this.savings += deposit;
	}
	
	public void withdraw(int withdraw) {
		this.savings -= withdraw;
	}

	public void popLeastRecentTransaction() {
		if(this.recentTransactions.size() > 0) {
			this.recentTransactions.remove(0);
		}
	}

	public void pushRecentTransaction(String transaction) {
		this.recentTransactions.add(transaction);
	}
	
	public void xMostRecentTransaction(int x) {
		if (this.recentTransactions.size() > x) {
			popLeastRecentTransaction();
		}
	}
	
}
