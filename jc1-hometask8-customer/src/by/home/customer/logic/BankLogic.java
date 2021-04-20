package by.home.customer.logic;

import java.util.ArrayList;

import by.home.customer.entity.Bank;
import by.home.customer.entity.Customer;

public class BankLogic {
	public Customer findCustomerById(int id, ArrayList<Customer> customerList) {
		Customer customer = null;

		for (Customer cust : customerList) {
			if (cust.getId() == id) {
				customer = cust;
				break;
			}
		}

		return customer;
	}

	public Customer findCustomerByCardNumber(int cardNumber, ArrayList<Customer> customerList) {
		Customer customer = null;

		for (Customer cust : customerList) {
			if (cust.getCardNumber() == cardNumber) {
				customer = cust;
				break;
			}
		}

		return customer;
	}

	public Customer findCustomerByBankAccountNumber(String bankAccountNumber, ArrayList<Customer> customerList) {
		Customer customer = null;

		for (Customer cust : customerList) {
			if (cust.getBankAccountNumber().equals(bankAccountNumber)) {
				customer = cust;
				break;
			}
		}

		return customer;
	}

	public Customer addCustomer(Bank bank, String lastName, String firstName, String middleName, String address,
			int cardNumber, String bankAccountNumber) {

		int customerId = bank.getCustomerId() + 1;

		Customer customer = null;

		if ((lastName == null) || (lastName == "")) {
			throw new RuntimeException("Customer LastName can not be empty!");
		} else if ((cardNumber < 1000) || (cardNumber > 9999)) {
			throw new RuntimeException("Customer cardNumber must be in range 1000 .. 9999!");
		} else if (findCustomerByCardNumber(cardNumber, bank.getCustomerList()) != null) {
			throw new RuntimeException("Customer Credit Card Number is not unique!");
		} else if ((bankAccountNumber == null) || (bankAccountNumber == "")) {
			throw new RuntimeException("Customer BankAccount can not be empty!!");
		} else if (findCustomerByBankAccountNumber(bankAccountNumber, bank.getCustomerList()) != null) {
			throw new RuntimeException("Customer Bank Account Number is not unique!");
		}

		customer = new Customer(customerId, lastName, firstName, middleName, address, cardNumber, bankAccountNumber);

		bank.getCustomerList().add(customer);
		bank.setCustomerId(customerId);

		return customer;
	}

	public ArrayList<Customer> sortCustomersByFIO(ArrayList<Customer> customerList) {

		ArrayList<Customer> sortedList = new ArrayList<Customer>();
		
		sortedList.addAll(customerList);
		
		BubleSort(0, sortedList.size() - 1, sortedList);

		return sortedList;
	}

	private int compareCustomer(Customer cust1, Customer cust2) {
		String custFIO1 = cust1.getLastName() + " " + cust1.getFirstName() + cust1.getMiddleName();
		String custFIO2 = cust2.getLastName() + " " + cust2.getFirstName() + cust2.getMiddleName();

		return custFIO1.compareTo(custFIO2);
	}

	private void swapCustomers(int pos1, int pos2, ArrayList<Customer> customerList) {
		Customer tmpCustomer = customerList.get(pos1);
		customerList.set(pos1, customerList.get(pos2));
		customerList.set(pos2, tmpCustomer);
	}

	// сортировка списка с указанной позиции по указанную.
	private void BubleSort(int pos1, int pos2, ArrayList<Customer> customerList) {
		if (pos2 - pos1 < 1) {
			return;
		}

		boolean isSorted;

		for (int i = pos1; i + 1 <= pos2; i++) {

			isSorted = true;

			for (int j = pos1; j + 1 <= pos2; j++) {
				if (compareCustomer(customerList.get(j), customerList.get(j + 1)) > 0) {
					swapCustomers(j, j + 1, customerList);
					isSorted = false;
				}
			}

			if (isSorted == true) {
				break;
			}
		}
	}
	
	public ArrayList<Customer> getCustomersByCardRange(int minRange, int maxRange, ArrayList<Customer> customerList) {
		ArrayList<Customer> resultCustomerList = new ArrayList<Customer>();
		
		for (Customer cust : customerList) {
			if ((cust.getCardNumber() >= minRange) &&
					(cust.getCardNumber() <= maxRange)) {
				resultCustomerList.add(cust);
			}
		}
		
		return resultCustomerList;
	}

}
