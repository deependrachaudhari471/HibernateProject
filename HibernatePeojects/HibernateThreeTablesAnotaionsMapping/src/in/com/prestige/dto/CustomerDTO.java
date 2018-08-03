package in.com.prestige.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="customer")
public class CustomerDTO {
  @Id
  @Column(name="customerID")
  private Integer customerId;
  @Column(name="Name")
  private String customerName;
  
}
