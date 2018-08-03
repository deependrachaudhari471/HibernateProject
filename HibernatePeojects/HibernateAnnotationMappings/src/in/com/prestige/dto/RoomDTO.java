package in.com.prestige.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms_many_to_one")
public class RoomDTO {
	@Id
	@Column(name = "ROOM_ID")
	private Integer roomNumber;
	@Column(name = "price")
	private Double pricePerDay;
	@Column(name = "floor")
	private Integer floor;
	@Column(name = "maxperson")
	private Integer maxPerson;
	@ManyToMany(targetEntity = GuestDTO.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name = "room_guest", joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "ROOM_ID"), inverseJoinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "GuestId"))
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
