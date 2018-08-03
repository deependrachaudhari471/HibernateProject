package in.com.prestige.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "guest_many_to_many")
public class GuestDTO {
	@Id
	@Column(name = "GuestId")
	private Integer guestId;
	@Column(name = "FNAME")
	private String fName;
	@Column(name = "LNAME")
	private String lName;
	@Column(name = "Phone")
	private String phone;

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set getRooms() {
		return rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

	@Column(name = "Address")
	private String address;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "ENTRY_TIME")
	private Timestamp time;

	@ManyToMany(targetEntity = RoomDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "room_guest", joinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "GuestId"), inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "ROOM_ID"))
	private Set rooms;
}
