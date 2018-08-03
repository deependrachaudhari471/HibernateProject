package in.com.prestige.dto;

import java.util.Set;

public class RoomDTO {
	private Integer roomNumber;
	private Double pricePerDay;
	private Integer floor;
	private Integer maxPerson;
	private Set guests;

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(Integer maxPerson) {
		this.maxPerson = maxPerson;
	}

	public Set getGuests() {
		return guests;
	}

	public void setGuests(Set guests) {
		this.guests = guests;
	}

}
