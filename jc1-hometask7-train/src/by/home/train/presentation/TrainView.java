package by.home.train.presentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import by.home.train.entity.Train;

public class TrainView {
	public void printTrain(String strBefore, Train train, String strAfter) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY HH:mm");
		
		System.out.printf("%s %03d %s %s %s", strBefore,  
										   train.getTrainNumber(), 
										   train.getDestinationStation(), 
										   sdf.format(train.getDepartureDateTime()),
										   strAfter);
	}
	
	public void printTrainsList(ArrayList<Train> trainsList) {
		
		int i= 0;
		
		for (Train tr : trainsList) {
			i++;			
			printTrain(i + ")", tr, "\n");
		}
	}
}
