package in.com.prestige.dto;

public class PassengersDTO {
	private Integer passengerId;
	private String pName;
	private TrainDTO passenger;

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public TrainDTO getPassenger() {
		return passenger;
	}

	public void setPassenger(TrainDTO passenger) {
		this.passenger = passenger;
	}
}
