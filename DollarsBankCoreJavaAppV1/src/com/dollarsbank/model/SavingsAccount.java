package com.dollarsbank.model;

import java.util.List;

public class SavingsAccount extends Account {
	
	private float savings;
	private List<String> recentTransactions;

	public SavingsAccount(String userId, String password, float savings) {
		super(userId, password);
		this.savings = savings;
	}

	public float getSavings() {
		return savings;
	}

	public void setSavings(float savings) {
		this.savings = savings;
	}
	
	public List<String> getRecentTransactions() {
		return recentTransactions;
	}
	
	public void setRecentTransactions(List<String> recentTransactions) {
		this.recentTransactions = recentTransactions;
	}
	
	public void deposit(float deposit) {
		this.savings += deposit;
	}
	
	public void withdraw(float withdraw) {
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

	@Override
	public String toString() {
		return "SavingsAccount [userid=" + super.getUserId() + ", password=" + super.getPassword() + ", savings=" + savings + "]";
	}
	
	
	
}
