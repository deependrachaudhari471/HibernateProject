package in.com.prestige.dto;

import java.util.Set;

public class DeveloperDTO {
	private Integer developerId;
	private String developerName;
	private Set projectId;
	public Integer getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public Set getProjectId() {
		return projectId;
	}
	public void setProjectId(Set projectId) {
		this.projectId = projectId;
	}
}
