package in.com.prestige.dto;

import java.util.Set;

public class StudentDTO {
	private Integer studentId;
	private String studentName;
	private Integer marks;
	private Set courses;

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

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Set getCourses() {
		return courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}
}
