package in.com.prestige.dto;

public class CustomerDTO {
	private Integer customerID;
	private String customerName;
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
