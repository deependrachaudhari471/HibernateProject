package in.com.prestige.dto;

public class VehicleDTO {
	private Integer vehicleId;
	private String vehicleName;
	private UserDTO userid;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public UserDTO getUserid() {
		return userid;
	}

	public void setUserid(UserDTO userid) {
		this.userid = userid;
	}

	

}
