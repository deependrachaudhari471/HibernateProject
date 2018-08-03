package in.com.prestige.dto;

public class AddressDTO {
	private Integer addressId;
	private String city;
	private String state;
	private String addresType;
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

	public String getAddresType() {
		return addresType;
	}

	public void setAddresType(String addresType) {
		this.addresType = addresType;
	}

	public StudentDTO getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentDTO studentId) {
		this.studentId = studentId;
	}
	
}
