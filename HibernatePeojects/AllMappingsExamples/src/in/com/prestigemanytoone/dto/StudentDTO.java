package in.com.prestigemanytoone.dto;

public class StudentDTO {
	private Integer studentId;
	private String studentName;
	private AddressDTO addressId;

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

	public AddressDTO getAddressId() {
		return addressId;
	}

	public void setAddressId(AddressDTO addressId) {
		this.addressId = addressId;
	}
}
