package in.com.prestigeonetomanybidirectional;

import java.util.Set;

public class TrainDTO {
	private Integer TainNo;
	private String TrainName;
	private Set passengers;

	public Integer getTainNo() {
		return TainNo;
	}

	public void setTainNo(Integer tainNo) {
		TainNo = tainNo;
	}

	public String getTrainName() {
		return TrainName;
	}

	public void setTrainName(String trainName) {
		TrainName = trainName;
	}

	public Set getPassengers() {
		return passengers;
	}

	public void setPassengers(Set passengers) {
		this.passengers = passengers;
	}
}
