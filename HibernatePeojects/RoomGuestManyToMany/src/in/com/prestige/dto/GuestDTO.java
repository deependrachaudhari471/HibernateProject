package in.com.prestige.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class GuestDTO {
	private Integer guestId;
	private String fName;
	private String lName;
	private String phone;
	private String address;
	private Date date;
	private Timestamp time;
	private Set rooms;

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
}
