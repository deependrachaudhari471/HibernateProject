package in.com.prestige.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_Order")
public class CustomerOrderDTo {
	@Id
	@Column(name = "CID")
	private Integer cId;
	@Column(name = "CNAME")
	private String Name;
	@OneToMany(targetEntity = OrderDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "CID",nullable=false , referencedColumnName = "CID")
	private Set orders;

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Set getOrders() {
		return orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}
}
