package in.com.prestige.tableperconcrete;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cheque_per_concrete_class_annotation")
@AttributeOverrides({
	@AttributeOverride(name="paymentId",column=@Column(name="paymentId")),
	@AttributeOverride(name="amount",column=@Column(name="paymentId"))
})
public class ChequeDTO extends PaymentDTO {
	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	private String chequeType;

}
