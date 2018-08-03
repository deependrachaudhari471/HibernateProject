package in.com.prestige.tablepersubclass;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cheque_per_subclass_annotation")
@PrimaryKeyJoinColumn(name = "ID")
public class ChequeDTO extends PaymentDTO {
	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	private String chequeType;

}
