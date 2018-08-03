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
@Table(name = "manufacture")
public class ManufacturedDTO {
	@Id
	@Column(name = "MId")
	private Integer mId;
	@Column(name = "ManuName")
	private String companyName;
	
	@OneToMany(targetEntity=CustomerDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="manu_id",referencedColumnName="MID")
	private Set customers;
	
	@OneToMany(targetEntity=VendorDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="manu_id",referencedColumnName="MID")
	private Set vendors;
}
