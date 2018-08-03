package in.com.prestige.dto;

import java.util.Date;

public class EmployeeDTO {
	private Integer employeeId;
	private String firsName;
	private String lastName;
	private Date birthDate;
	private Integer fordepartkey;
	
	public Integer getFordepartkey() {
		return fordepartkey;
	}
	public void setFordepartkey(Integer fordepartkey) {
		this.fordepartkey = fordepartkey;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	

}
