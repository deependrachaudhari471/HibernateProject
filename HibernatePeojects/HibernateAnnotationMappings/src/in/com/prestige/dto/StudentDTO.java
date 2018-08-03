package in.com.prestige.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_one_to_one")
public class StudentDTO implements Serializable{
	@Id
	@Column(name = "STUDENT_ID")
	private Integer studentId;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Column(name = "PHONE")
	private String contactNO;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getContactNO() {
		return contactNO;
	}

	public void setContactNO(String contactNO) {
		this.contactNO = contactNO;
	}

}
