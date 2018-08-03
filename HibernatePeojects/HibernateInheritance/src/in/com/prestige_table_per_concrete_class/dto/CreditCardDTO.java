package in.com.prestige_table_per_concrete_class.dto;

public class CreditCardDTO extends PaymentDTO {
	private String creditCardType;

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
}
