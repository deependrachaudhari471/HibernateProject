package in.com.prestige.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_table")
public class StudentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "StudentId")
	private Integer studentID;
	@Column(name = "StudentName")
	private String studentName;
	@Column(name = "Address")
	private String address;
	@Column(name = "contact")
	private String conatanctNo;

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConatanctNo() {
		return conatanctNo;
	}

	public void setConatanctNo(String conatanctNo) {
		this.conatanctNo = conatanctNo;
	}

}
