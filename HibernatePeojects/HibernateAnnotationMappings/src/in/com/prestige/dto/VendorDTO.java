package in.com.prestige.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_one_to_many")
public class VendorDTO {
	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Set getCustomers() {
		return customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

	@Id
	@Column(name = "VENDORID")
	private Integer vendorId;
	@Column(name = "VendorName")
	private String vendorName;

	@OneToMany(targetEntity = CustomersDTO.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "VID", referencedColumnName = "VENDORID")
	private Set customers;
}
