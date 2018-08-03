package in.com.prestige.dto;

public class AddressDTO {
	private Integer addressId;
	private String city;
	private String state;
	private String zipcode;
	private PersonDTO personID;
	
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public PersonDTO getPersonID() {
		return personID;
	}
	public void setPersonID(PersonDTO personID) {
		this.personID = personID;
	}
}
