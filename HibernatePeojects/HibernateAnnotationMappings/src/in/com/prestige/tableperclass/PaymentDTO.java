package in.com.prestige.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="payment_annotation_per_sub_class")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dcolumn",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="payment")
public class PaymentDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="payment_id")
	private Integer paymentId;
    @Column(name="Amount")
	private Double amount;
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

}
