package in.com.prestige.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank_many_to_one")
public class BankDTO {
	@Id
	@Column(name="Bank_Id")
	private Integer bankId;
	@Column(name="Bank_Name")
	private String bankName;
	@Column(name="Address")
	private String address;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
    
}
