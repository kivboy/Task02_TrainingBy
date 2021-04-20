package by.home.train.main;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import by.home.train.entity.Depo;
import by.home.train.entity.Train;
import by.home.train.logic.TrainLogic;
import by.home.train.presentation.DepoView;
import by.home.train.presentation.TrainView;

public class Main {

	public static void main(String[] args) {
								
		TrainLogic trLogic = new TrainLogic();
			
		Train train1 = trLogic.createTrain(89, "Москва", parseDate(2021, 4, 24, 12, 18));
				
		Train train2 = trLogic.createTrain(127, "Киев", parseDate(2021, 4, 27, 11, 45));
		
		Train train3 = trLogic.createTrain(30, "Гомель", parseDate(2021, 5, 25, 14, 38));
						
		Train train4 = trLogic.createTrain(153, "Одесса", parseDate(2021, 5, 03, 23, 32));
						
		Train train5 = trLogic.createTrain(74, "Одесса", parseDate(2021, 4, 14, 9, 54));
								
		Train train6 = trLogic.createTrain(130, "Гомель", parseDate(2021, 5, 9, 14, 38));
		
		Depo depo = new Depo("Минск-Пассажирский");
		
		// добавление поездов в депо
		depo.addTrain(train1);
		depo.addTrain(train2);
		depo.addTrain(train3);
		depo.addTrain(train4);
		depo.addTrain(train5);
		depo.addTrain(train6);
		
		// вывод списка всех поездов депо
		DepoView dpView = new DepoView();
		dpView.printDepo(depo);
		
		System.out.println("\nПоиск поезда по коду:");
		
		// поиск поезда по коду
		TrainView trView = new TrainView();
		int trNumber = 127;
		
		Train trainX = trLogic.findTrainByNumber(trNumber, depo.getTrains());	
		
		if (trainX != null) {
			trView.printTrain("поезд найден ->", trainX, "\n");
		} else {
			System.out.println("Поезд с номером " + trNumber + " не найден!\n");
		}
		
		// поиск поездов по направлению (вывод сортированный + сортировка по дате отправления)
		System.out.println("\nСортировка по пункту назначения:");
		
		trView.printTrainsList(trLogic.sortTrainsByDestAndTime(depo.getTrains()));
		
	}
	
	public static Date parseDate(int year, int month, int day, int hour, int minute) {
		// внимание - значение месяца начинаетя с нуля!
		Calendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute); 
				
		return calendar.getTime();
	}

}
