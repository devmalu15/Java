package SkillSpaceTerminalBasedApp;

import java.sql.Connection;

public interface ISkillSpaceMethods {
	
	Connection connectDB();
	
	int register(Connection con, User user);
	
	boolean checkId(Connection con, String id);
	
	boolean checkIdPassword(Connection con, String id, String password);
	
	User login(Connection con, String id, String password);
	
	void home(Connection con, User currentUser);
	
	void myProjects(Connection con, User currentUser);
	
	User logout(User currentUser) ;
	
	void showPings(Connection con, User currentUser);
	
	void pingProject(Connection con, User currentUser, int projectId);
	
	int createProject(Connection con, Project project);
	
	void menu(Connection con);
	
	void loginMenu(Connection con);
	
	void createProjectMenu(Connection con);

}
