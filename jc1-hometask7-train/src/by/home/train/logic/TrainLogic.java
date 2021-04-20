package by.home.train.logic;

import java.util.ArrayList;
import java.util.Date;

import by.home.train.entity.Train;

public class TrainLogic {
	// создание объекта поезда с проверками
	public Train createTrain(int trainNumber, String destinationStation, Date departureDateTime) {

		if (trainNumber <= 0) {
			throw new RuntimeException("Train number must by positive number!");
		}

		if ((destinationStation == null) || (destinationStation == "")) {
			throw new RuntimeException("destinationStation mustn't be empty!");
		}

		if (departureDateTime == null) {
			throw new RuntimeException("Departure time can't be null!");
		}

		return new Train(trainNumber, destinationStation, departureDateTime);
	}

	// найти поезд по номеру. Если не нашли возвращаем null
	public Train findTrainByNumber(int trainNumber, ArrayList<Train> trainsList) {
		Train train = null;

		for (Train tr : trainsList) {
			if (tr.getTrainNumber() == trainNumber) {
				train = tr;
				break;
			}
		}

		return train;
	}

	public ArrayList<Train> sortTrainsByNumber(ArrayList<Train> trainsList) {
		ArrayList<Train> sortedTrainsList = new ArrayList<Train>();

		sortedTrainsList.addAll(trainsList);

		BubleSort(0, sortedTrainsList.size() - 1, 0, sortedTrainsList);

		return sortedTrainsList;
	}

	public ArrayList<Train> sortTrainsByDestAndTime(ArrayList<Train> trainsList) {
		ArrayList<Train> sortedTrainsList = new ArrayList<Train>();

		sortedTrainsList.addAll(trainsList);

		// сортируем по месту назначения
		BubleSort(0, sortedTrainsList.size() - 1, 1, sortedTrainsList);

		// сортируем по времени в рамках места назначения

		int startPos = 0;
		boolean isChanged;

		for (int i = 1; i < sortedTrainsList.size(); i++) {
			isChanged = !sortedTrainsList.get(i).getDestinationStation()
					.equalsIgnoreCase(sortedTrainsList.get(startPos).getDestinationStation());
			
			if ((i - startPos > 1) && isChanged) {
				// сортируем по времени
				BubleSort(startPos, i - 1, 2, sortedTrainsList);
				startPos = i;
			} else if ((i - startPos >= 1) && (i == sortedTrainsList.size() - 1)) {
				// сортируем по времени
				BubleSort(startPos, i, 2, sortedTrainsList);
			} else if (isChanged) {
				startPos = i;
			}			
		}

		return sortedTrainsList;
	}

	// смена местами для сортировки
	private void swapTrains(int pos1, int pos2, ArrayList<Train> trainsList) {
		Train tmpTrain = trainsList.get(pos1);
		trainsList.set(pos1, trainsList.get(pos2));
		trainsList.set(pos2, tmpTrain);
	}

	// сортировка списка с указанной позиции по указанную.
	// flag - по какому полю сортировать: 0 - по номеру, 1 - по пункту назначения, 2
	// - по времени
	private void BubleSort(int pos1, int pos2, int flag, ArrayList<Train> trainsList) {
		if (pos2 - pos1 < 1) {
			return;
		}

		boolean isSorted;

		for (int i = pos1; i + 1 <= pos2; i++) {

			isSorted = true;

			for (int j = pos1; j + 1 <= pos2; j++) {
				if (compareTrain(trainsList.get(j), trainsList.get(j + 1), flag) > 0) {
					swapTrains(j, j + 1, trainsList);
					isSorted = false;
				}
			}

			if (isSorted == true) {
				break;
			}
		}
	}

	// сравнение с использованием флага (какое поле сравнивать)
	// возвращает -1 - если атрибут 1-го меньше 2-го
	// 0 - если атрибуты равны
	// 1 - если атрибут 1-го больше 2-го
	private int compareTrain(Train tr1, Train tr2, int flag) {

		int result = 0;

		switch (flag) {
		case 1: // flag = 1 сравнение по пункту назначения
			result = tr1.getDestinationStation().compareToIgnoreCase(tr2.getDestinationStation());
			break;

		case 2: // flag = 2 сравнение по дате отправления
			result = tr1.getDepartureDateTime().compareTo(tr2.getDepartureDateTime());
			break;

		default: // flag = 0(по умолчанию) сравнение по номеру поезда
			if (tr1.getTrainNumber() > tr2.getTrainNumber()) {
				result = 1;
			} else if (tr1.getTrainNumber() < tr2.getTrainNumber()) {
				result = -1;
			} else {
				result = 0;
			}
		}

		return result;
	}
}
