package by.home.customer.presentation;

import java.util.ArrayList;

import by.home.customer.entity.Customer;

public class BankView {
	public void printCustomerList(ArrayList<Customer> customerList) {
		int i = 0;		
		for (Customer cust : customerList) {
			i++;
			printCustomer(i + ")", cust, "\n");			
		}
	}
	
	public void printCustomer(String strBefore, Customer customer, String strAfter) {
		String custFIO = customer.getLastName() + " " + customer.getFirstName().substring(0, 1) + "." + customer.getMiddleName().substring(0, 1) + ".";
		
		System.out.printf("%s %s, карта %04d %s", strBefore, custFIO, customer.getCardNumber(), strAfter);		
	}
}
