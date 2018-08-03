package in.com.prestige.dto;

public class ComputerDTO {
	private Integer computerId;
	private String computerBrand;
	private String type;
	private OfficeDTO officeId;

	public Integer getComputerId() {
		return computerId;
	}

	public void setComputerId(Integer computerId) {
		this.computerId = computerId;
	}

	public String getComputerBrand() {
		return computerBrand;
	}

	public void setComputerBrand(String computerBrand) {
		this.computerBrand = computerBrand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public OfficeDTO getOfficeId() {
		return officeId;
	}

	public void setOfficeId(OfficeDTO officeId) {
		this.officeId = officeId;
	}

}
