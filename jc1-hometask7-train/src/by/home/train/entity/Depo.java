package by.home.train.entity;

import java.util.ArrayList;

public class Depo {
	public static final String DEFAULT_DEPO_NAME = "NoName";
	private String depoName;
	private ArrayList<Train> trainsList;
	
	public Depo() {
		this.trainsList = new ArrayList<Train>();
		this.depoName = DEFAULT_DEPO_NAME;		
	}
	
	public Depo(String depoName) {
		this.trainsList = new ArrayList<Train>();
		this.depoName = depoName;		 
	}
		
	public String getDepoName() {
		return depoName;
	}

	public void setDepoName(String depoName) {
		this.depoName = depoName;
	}

	public void addTrain(Train train) {
		this.trainsList.add(train);		
	}
	
	public int getTrainsCount() {
		return trainsList.size() + 1; 
	}
	
	public ArrayList<Train> getTrains() {
		return this.trainsList;
	}
	
	public void setTrains(ArrayList<Train> newTrainsList) {
		this.trainsList = newTrainsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depoName == null) ? 0 : depoName.hashCode());
		result = prime * result + ((trainsList == null) ? 0 : trainsList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Depo other = (Depo) obj;
		if (depoName == null) {
			if (other.depoName != null)
				return false;
		} else if (!depoName.equals(other.depoName))
			return false;
		if (trainsList == null) {
			if (other.trainsList != null)
				return false;
		} else if (!trainsList.equals(other.trainsList))
			return false;
		return true;
	}
	
	
}
