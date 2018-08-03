package in.com.prestige.dto;




import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="vnedor")
public class VendorDTO {
	@Id
	@Column(name="VendorID")
    private Integer vendorId;
	@Column(name="vendorName")
	private String vendorName;
	
	@OneToMany(targetEntity=CustomerDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="VID",referencedColumnName="VendorID")
	private Set customers;
	
}
