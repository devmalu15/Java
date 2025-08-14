package SkillSpaceTerminalBasedApp;

public class User {
	private String name;
	private String id;
	private String password;
	private String course;
	private int year;
	private String gender;
	
	
	public User(String name, String course, int year, String gender, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.course = course;
		this.year = year;
		this.gender = gender;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
