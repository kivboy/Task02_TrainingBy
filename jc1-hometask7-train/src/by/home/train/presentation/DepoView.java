package by.home.train.presentation;

import java.util.ArrayList;

import by.home.train.entity.Depo;
import by.home.train.entity.Train;
import by.home.train.logic.TrainLogic;

public class DepoView {
	public void printDepo(Depo depo) {
		System.out.println("Депо: " + depo.getDepoName());
				
		TrainLogic trLogic = new TrainLogic();
		ArrayList<Train> trainsList = trLogic.sortTrainsByNumber(depo.getTrains());
						
		TrainView trView = new TrainView();
		
		trView.printTrainsList(trainsList);
	}
}
