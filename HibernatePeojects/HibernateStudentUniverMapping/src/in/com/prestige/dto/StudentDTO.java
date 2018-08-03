package in.com.prestige.dto;

import java.util.Date;

public class StudentDTO {
	private Integer studentID;
	private String firstName;
	private String lastName;
	private Integer universityID;

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getUniversityID() {
		return universityID;
	}

	public void setUniversityID(Integer universityID) {
		this.universityID = universityID;
	}
}
