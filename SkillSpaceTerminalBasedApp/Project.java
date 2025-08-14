package SkillSpaceTerminalBasedApp;

public class Project{
	private int projectId;
	private String title;
	private String ownerId;
	private String requirement;
	private String description;
	private String[] pings;
	
	
	
	public Project(int projectId, String title, String ownerId, String requirement, String description) {
		this.projectId = projectId;
		this.title = title;
		this.ownerId = ownerId;
		this.requirement = requirement;
		this.description = description;
		pings = null;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String owner) {
		this.ownerId = owner;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	public String[] getPings() {
		return pings;
	}



	public void setPings(String[] pings) {
		this.pings = pings;
	}



	public int getProjectId() {
		return projectId;
	}



	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
}

