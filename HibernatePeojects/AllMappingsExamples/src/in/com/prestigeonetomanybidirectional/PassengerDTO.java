package in.com.prestigeonetomanybidirectional;

public class PassengerDTO {
 private Integer passengerId;
 private String PassengerName;
	private TrainDTO trainId;

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return PassengerName;
	}

	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}

	public TrainDTO getTrainId() {
		return trainId;
	}

	public void setTrainId(TrainDTO trainId) {
		this.trainId = trainId;
	}
}
