package in.com.prestige.dto;

public class CustomerDTO {
	private Integer customerID;
	private String customerName;
	private Integer forevenId;

	public Integer getForevenId() {
		return forevenId;
	}

	public void setForevenId(Integer forevenId) {
		this.forevenId = forevenId;
	}

	private VendorDTO parentObject;

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public VendorDTO getParentObject() {
		return parentObject;
	}

	public void setParentObject(VendorDTO parentObject) {
		this.parentObject = parentObject;
	}

}
