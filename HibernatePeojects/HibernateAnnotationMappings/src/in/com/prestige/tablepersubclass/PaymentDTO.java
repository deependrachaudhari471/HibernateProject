package in.com.prestige.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="paymnet_per_sub_class_annotation")
@Inheritance(strategy=InheritanceType.JOINED)
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
