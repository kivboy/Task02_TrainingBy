package by.home.customer.entity;

import java.util.ArrayList;

public class Bank {
	private String name;
	private int customerId;
	private ArrayList<Customer> customerList;

	public Bank() {
		this.name = "Unknown";
		this.customerList = new ArrayList<Customer>();
		this.customerId = 0;
	}

	public Bank(String name) {
		this.name = name;
		this.customerList = new ArrayList<Customer>();
		this.customerId = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}	
	
	
}
