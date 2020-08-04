package com.dollarsbank.model;

public class Customer {
	
	private String name;
	private String address;
	private String contactNum;
	private Account bankAccount;
	
	public Customer() {
		
	}
	
	public Customer(String name, String address, String contactNum, Account bankAccount) {
		super();
		this.name = name;
		this.address = address;
		this.contactNum = contactNum;
		this.bankAccount = bankAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public Account getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", contactNum=" + contactNum + ", bankAccount="
				+ bankAccount + "]";
	}
}
