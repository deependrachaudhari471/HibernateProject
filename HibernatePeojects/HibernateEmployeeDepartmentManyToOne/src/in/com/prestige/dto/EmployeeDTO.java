package in.com.prestige.dto;

public class EmployeeDTO {
	private Integer empId;
	private String empName;
	private String empAddress;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public DepartmentDTO getDepartID() {
		return departID;
	}

	public void setDepartID(DepartmentDTO departID) {
		this.departID = departID;
	}

	private DepartmentDTO departID;
}
