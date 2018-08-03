package in.com.prestige.dto;

import java.util.Set;

public class CustomerDTO {
	private Integer customerID;
	private String customerName;
	private Set orders;

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

	public Set getOrders() {
		return orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}
}
