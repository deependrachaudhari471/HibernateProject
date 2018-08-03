package in.com.prestige.dto;

import java.util.Set;

public class UniversityDTO {
	private Integer uID;
	private String uName;
	private String country;
	private Set studentID;

	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set getStudentID() {
		return studentID;
	}

	public void setStudentID(Set studentID) {
		this.studentID = studentID;
	}
}
