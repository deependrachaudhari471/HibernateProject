package in.com.prestige.dto;

public class ProjectsDTO {
	private Integer projectId;
	private String ProjectName;
	private Integer developerId;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public Integer getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}
}
