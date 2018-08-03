package in.com.prestige.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_many_to_one")
public class AccountHoldersDTO {

	@Id
	@Column(name = "AccountNo")
	private Integer accountNo;
	@Column(name = "Name")
	private String Name;
	@Column(name = "phone")
	private String phone;
	@ManyToOne(cascade = CascadeType.ALL ,fetch=FetchType.LAZY)
	@JoinColumn(name = "Bank_Id", referencedColumnName = "Bank_Id")
	private BankDTO bankId;

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BankDTO getBankId() {
		return bankId;
	}

	public void setBankId(BankDTO bankId) {
		this.bankId = bankId;
	}
}
