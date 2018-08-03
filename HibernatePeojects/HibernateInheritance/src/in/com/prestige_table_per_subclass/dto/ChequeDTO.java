package in.com.prestige_table_per_subclass.dto;

public class ChequeDTO extends PaymentDTO{
	private String chequeType;

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
}
