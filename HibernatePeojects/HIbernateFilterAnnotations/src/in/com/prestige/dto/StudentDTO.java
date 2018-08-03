package in.com.prestige.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "student_filter_annotation")
@FilterDef(name = "student_name", parameters = { @ParamDef(name = "age_param", type = "int") })
@Filters({ @Filter(name = "student_name", condition = "STUDENT_NAME like '%a%'"),
		@Filter(name = "student_name", condition = "AGE>=:age_param") })

public class StudentDTO {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private Integer studentId;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Column(name = "ADRESS")
	private String address;
	@Column(name = "AGE")
	private Integer age;

}
