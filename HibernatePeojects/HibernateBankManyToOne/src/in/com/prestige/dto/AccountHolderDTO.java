package in.com.prestige.dto;

public class AccountHolderDTO {
	private Integer acHolderId;
	private String  acHolderName;
	private String acNumber;
	private BankDTO bankId;

	public Integer getAcHolderId() {
		return acHolderId;
	}

	public void setAcHolderId(Integer acHolderId) {
		this.acHolderId = acHolderId;
	}

	public String getAcHolderName() {
		return acHolderName;
	}

	public void setAcHolderName(String acHolderName) {
		this.acHolderName = acHolderName;
	}

	public String getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

	public BankDTO getBankId() {
		return bankId;
	}

	public void setBankId(BankDTO bankId) {
		this.bankId = bankId;
	}
}
