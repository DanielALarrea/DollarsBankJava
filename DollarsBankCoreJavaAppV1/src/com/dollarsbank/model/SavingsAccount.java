package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account {
	
	private float savings;
	private List<String> recentTransactions;
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String userId, String password) {
		super(userId, password);
		this.savings = 0;
		this.recentTransactions = new ArrayList<String>();
	}

	public SavingsAccount(String userId, String password, float savings) {
		super(userId, password);
		this.savings = savings;
		this.recentTransactions = new ArrayList<String>();
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
	
	public List<String> xMostRecentTransaction(int x) {
		List<String> mostRecentTransactions = new ArrayList<String>();
		int listLength = this.recentTransactions.size();
		int startIndex = listLength - x;
		if (listLength < x) {
			startIndex = 0;
		}
		for(int i = startIndex; i < listLength; i++) {
			mostRecentTransactions.add(this.recentTransactions.get(i));
		}
		
		return mostRecentTransactions;
	}

	@Override
	public String toString() {
		return "SavingsAccount [userid=" + super.getUserId() 
						 + ", password=" + super.getPassword() 
						 + ", savings=" + savings 
						 + ", recentTransactions=" + recentTransactions + "]";
	}
}
