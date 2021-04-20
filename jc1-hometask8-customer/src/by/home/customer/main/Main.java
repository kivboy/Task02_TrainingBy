package by.home.customer.main;

import java.util.ArrayList;

import by.home.customer.entity.Bank;
import by.home.customer.entity.Customer;
import by.home.customer.logic.BankLogic;
import by.home.customer.presentation.BankView;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank("Новый Банк");
		BankLogic bankLogic = new BankLogic();
				
		bankLogic.addCustomer(bank, "Иванов", "Иван", "Иванович", "пр-т. Мира, д.9, кв.65", 6798, "5676FF670");
		bankLogic.addCustomer(bank, "Петров", "Петр", "Петрович", "ул. Тимирязева, д.2, кв.3", 8795, "8973ОGHJ9");
		bankLogic.addCustomer(bank, "Терешков", "Иван", "Сергеевич", "ул. Пономаренко, д.25, кв.74", 3356, "7879ОMJKKLH9");
		bankLogic.addCustomer(bank, "Михеева", "Оксана", "Владиславовна", "ул. Чичурина, д.3, кв.66", 8087, "4676FF670");
				
		BankView bankView = new BankView();
		bankView.printCustomerList(bankLogic.sortCustomersByFIO(bank.getCustomerList()));
		
		int minRange = 8000;
		int maxRange = 8999;
		
		System.out.println("\nИщем покупателей по диапазону номеру карты " + minRange + " - " + maxRange + ":");
		
		ArrayList<Customer> resCustList = bankLogic.getCustomersByCardRange(minRange, maxRange, bank.getCustomerList());
		
		if (resCustList.size() > 0) {
			System.out.println("Найдено " + resCustList.size() + " покупателей по заданному критерию. \n");
			
			bankView.printCustomerList(bankLogic.sortCustomersByFIO(resCustList));
		} else {
			System.out.println("Покупателей по заданному критерию не найдено! \n");
		}
		
	}

}
