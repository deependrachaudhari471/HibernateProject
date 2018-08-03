package in.com.prestige.tablepersubclass;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Credit_per_subclass_annotation")
@PrimaryKeyJoinColumn(name="ID")
public class CreditCardDTO extends PaymentDTO {
	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	private String creditCardType;

}