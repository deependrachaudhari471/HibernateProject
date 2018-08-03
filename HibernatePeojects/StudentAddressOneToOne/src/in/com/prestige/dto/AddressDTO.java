package in.com.prestige.dto;

public class AddressDTO {
  private Integer addressId;
  private String city;
  private String state;
	private StudentDTO std;

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

	public StudentDTO getStd() {
		return std;
	}

	public void setStd(StudentDTO std) {
		this.std = std;
	}
}
