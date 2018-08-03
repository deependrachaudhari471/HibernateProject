package in.com.prestige.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address_one_to_one")
public class AddressDTO implements Serializable{
	@Id
	@Column(name = "ADDRESS_ID")
	private Integer addressId;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@OneToOne(targetEntity = StudentDTO.class, cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "StudentId", referencedColumnName = "STUDENT_ID")
	private StudentDTO studentId;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public StudentDTO getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentDTO studentId) {
		this.studentId = studentId;
	}

}
