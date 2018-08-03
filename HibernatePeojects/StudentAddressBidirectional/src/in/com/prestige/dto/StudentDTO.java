package in.com.prestige.dto;

import java.util.Set;

public class StudentDTO {
	private Integer sId;
	private String sName;
	private Set addressId;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Set getAddressId() {
		return addressId;
	}

	public void setAddressId(Set addressId) {
		this.addressId = addressId;
	}
}
