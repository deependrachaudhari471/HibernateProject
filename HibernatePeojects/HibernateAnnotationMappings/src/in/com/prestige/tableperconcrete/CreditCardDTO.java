package in.com.prestige.tableperconcrete;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Credit_per_concrete_class_annotation")
@AttributeOverrides({
	@AttributeOverride(name="paymentId",column=@Column(name="paymentId")),
	@AttributeOverride(name="amount",column=@Column(name="paymentId"))
})
public class CreditCardDTO extends PaymentDTO {
	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	private String creditCardType;

}