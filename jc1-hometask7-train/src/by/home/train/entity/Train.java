package by.home.train.entity;

import java.util.Date;

public class Train {
	private int trainNumber;
	private String destinationStation;
	private Date departureDateTime;
	
	public Train() {
		
	}
	
	public Train(int trainNumber, String destinationStation, Date departureDateTime) {
		this.trainNumber = trainNumber;
		this.destinationStation = destinationStation;
		this.departureDateTime = departureDateTime;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Date getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureDateTime == null) ? 0 : departureDateTime.hashCode());
		result = prime * result + ((destinationStation == null) ? 0 : destinationStation.hashCode());
		result = prime * result + trainNumber;
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
		Train other = (Train) obj;
		if (departureDateTime == null) {
			if (other.departureDateTime != null)
				return false;
		} else if (!departureDateTime.equals(other.departureDateTime))
			return false;
		if (destinationStation == null) {
			if (other.destinationStation != null)
				return false;
		} else if (!destinationStation.equals(other.destinationStation))
			return false;
		if (trainNumber != other.trainNumber)
			return false;
		return true;
	}
	
}
