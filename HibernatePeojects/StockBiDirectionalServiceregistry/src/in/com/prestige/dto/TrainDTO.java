package in.com.prestige.dto;

import java.util.Set;

public class TrainDTO {
	private Integer trainNo;
	private String trainName;
	private Set passengers;

	public Integer getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public Set getPassengers() {
		return passengers;
	}

	public void setPassengers(Set passengers) {
		this.passengers = passengers;
	}

}
