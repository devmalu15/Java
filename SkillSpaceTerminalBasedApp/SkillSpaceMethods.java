package SkillSpaceTerminalBasedApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class SkillSpaceMethods implements ISkillSpaceMethods {
	
	User currentUser = null;

    public Connection connectDB() {
        String url = "jdbc:postgresql://localhost/skillspace";
        String username = "postgres";
        String password = "devmalu";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return con;
    }

    public int register(Connection con, User user) {
        int status = 0;
        String sql = "insert into users(name, course, year, gender, id, password) values(?, ?, ?, ?, ?, ?)";
        
        if (!checkId(con, user.getId())) {
            System.out.println("Error: User with this ID already exists.");
            return 0;
        }

        try (PreparedStatement prepSt = con.prepareStatement(sql)) {
            prepSt.setString(1, user.getName());
            prepSt.setString(2, user.getCourse());
            prepSt.setInt(3, user.getYear());
            prepSt.setString(4, user.getGender());
            prepSt.setString(5, user.getId());
            prepSt.setString(6, user.getPassword());
        
            status = prepSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL statement issue during registration: " + e.getMessage());
        }
        return status;
    }

    public boolean checkId(Connection con, String id) {
        String sql = "select id from users where id = ?";
        try (PreparedStatement prepSt = con.prepareStatement(sql)) {
            prepSt.setString(1, id);
            try (ResultSet result = prepSt.executeQuery()) {
                return !result.next();
            }
        } catch (SQLException e) {
            System.out.println("SQL statement issue during id check: " + e.getMessage());
        }
        return false;
    }

    public boolean checkIdPassword(Connection con, String id, String password) {
        String sql = "select name from users where id = ? AND password = ?";
        try (PreparedStatement prepSt = con.prepareStatement(sql)) {
            prepSt.setString(1, id);
            prepSt.setString(2, password);
            try (ResultSet result = prepSt.executeQuery()) {
                return result.next();
            }
        } catch (SQLException e) {
            System.out.println("SQL statement issue during id and password check: " + e.getMessage());
        }
        return false;
    }

    public User login(Connection con, String id, String password) {
        String sql = "select name, course, year, gender, id, password from users where id = ? AND password = ?";
        
        try (PreparedStatement prepSt = con.prepareStatement(sql)) {
            prepSt.setString(1, id);
            prepSt.setString(2, password);
            try (ResultSet result = prepSt.executeQuery()) {
                if (result.next()) {
                    currentUser = new User(
                        result.getString("name"),
                        result.getString("course"),
                        result.getInt("year"),
                        result.getString("gender"),
                        result.getString("id"),
                        result.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL statement issue during login: " + e.getMessage());
        }
        return currentUser;
    }

    public void home(Connection con, User user) {
        if (user.getId().equals(currentUser.getId())) {
            String sql = "select projectid, title, ownerId, requirement, description from projects";
            try (PreparedStatement prepSt = con.prepareStatement(sql);
                 ResultSet result = prepSt.executeQuery()) {
                
            	while (result.next()) {
                    String projectId = result.getString("projectid");
                    String title = result.getString("title");
                    String ownerId = result.getString("ownerId");
                    String requirement = result.getString("requirement");
                    String description = result.getString("description");
                    
                    System.out.println("Project ID: " + projectId);
                    System.out.println("Title: " + title);
                    System.out.println("Owner: " + ownerId);
                    System.out.println("Requirement: " + requirement);
                    System.out.println("Description: " + description);
                    
                    System.out.println("\n");
            	}
            } catch (SQLException e) {
                System.out.println("SQL statement issue during project retrieval: " + e.getMessage());
            }
        }
        else {
        	System.out.println("invalid user");
        }
    }

    public void myProjects(Connection con, User user) {
        if (user.getId().equals(currentUser.getId())) {
            String currentOwnerId = currentUser.getId();
            String sql = "select projectid, title, ownerId, requirement, description from projects where ownerId = ?";
            try (PreparedStatement prepSt = con.prepareStatement(sql)) {
                prepSt.setString(1, currentOwnerId);
                try (ResultSet result = prepSt.executeQuery()) {
                    
                	while (result.next()) {
                        String projectId = result.getString("projectid");
                        String title = result.getString("title");
                        String ownerId = result.getString("ownerId");
                        String requirement = result.getString("requirement");
                        String description = result.getString("description");
                        
                        System.out.println("Project ID: " + projectId);
                        System.out.println("Title: " + title);
                        System.out.println("Owner: " + ownerId);
                        System.out.println("Requirement: " + requirement);
                        System.out.println("Description: " + description);
                        
                        System.out.println("\n");
                	}
            } catch (Exception e) {
                System.out.println("SQL statement issue during project retrieval: " + e.getMessage());
            }
            }catch(Exception e) {
            	System.out.println("SQL statement issue during project retrieval: " + e.getMessage());
            	}
            }
    }

    public User logout(User user) {
    	if(user.getId().equals(currentUser.getId())) {
    		currentUser = null;
    	}
        return currentUser;
    }

    public void showPings(Connection con, User user) {
        if (user.getId().equals(currentUser.getId())) {
            String currentOwnerId = currentUser.getId();
            String sql = "select projectid, title, ownerId, requirement, description, pings from projects where ownerId = ? and pings is not null";
            
            try (PreparedStatement prepSt = con.prepareStatement(sql)) {
                prepSt.setString(1, currentOwnerId);
                try (ResultSet result = prepSt.executeQuery()) {
                    while (result.next()) {
                        String projectId = result.getString("projectid");
                        String title = result.getString("title");
                        String ownerId = result.getString("ownerId");
                        String requirement = result.getString("requirement");
                        String description = result.getString("description");
                        java.sql.Array sqlArray = result.getArray("pings");

                        System.out.println("Project ID: " + projectId);
                        System.out.println("Title: " + title);
                        System.out.println("Owner: " + ownerId);
                        System.out.println("Requirement: " + requirement);
                        System.out.println("Description: " + description);
                        if (sqlArray != null) {
                            String[] javaArray = (String[]) sqlArray.getArray();
                            System.out.println("Pings: " + Arrays.toString(javaArray));
                        }
                        System.out.println("\n");
                    }
                }
            } catch (SQLException e) {
                System.out.println("SQL statement issue during project retrieval: " + e.getMessage());
            }
        }
    }

    public void pingProject(Connection con, User user, int projectId) {
        if (user.getId().equals(currentUser.getId())) {
            String currentOwnerId = currentUser.getId();
            
            String selectSql = "select pings from projects where projectid = ?";
            String updateSql = "update projects set pings = ? where projectid = ?";
            
            try (PreparedStatement selectPrepSt = con.prepareStatement(selectSql)) {
                selectPrepSt.setInt(1, projectId);
                try (ResultSet result = selectPrepSt.executeQuery()) {
                    if (result.next()) {
                        java.sql.Array oldSqlArray = result.getArray("pings");
                        String[] javaArray = (oldSqlArray != null) ? (String[]) oldSqlArray.getArray() : new String[0];
                        
                        String[] newArray = Arrays.copyOf(javaArray, javaArray.length + 1);
                        newArray[newArray.length - 1] = currentOwnerId;
                        
                        java.sql.Array newSqlArray = con.createArrayOf("text", newArray);
                        
                        try (PreparedStatement updatePrepSt = con.prepareStatement(updateSql)) {
                            updatePrepSt.setArray(1, newSqlArray);
                            updatePrepSt.setInt(2, projectId);
                            updatePrepSt.executeUpdate();
                            System.out.println("Project pinged successfully!");
                        }
                    } else {
                        System.out.println("Project not found with that ID.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("SQL statement issue during project ping: " + e.getMessage());
            }
        }
    }

    public int createProject(Connection con, Project project) {
        int status = 0;
        String sql = "insert into projects(projectid, title, ownerid, requirement, description, pings) values(?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement prepSt = con.prepareStatement(sql)) {
            prepSt.setInt(1, project.getProjectId());
            prepSt.setString(2, project.getTitle());
            prepSt.setString(3, project.getOwnerId());
            prepSt.setString(4, project.getRequirement());
            prepSt.setString(5, project.getDescription());
            prepSt.setArray(6, con.createArrayOf("text", project.getPings()));

            status = prepSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL statement issue during project creation: " + e.getMessage());
        }
        return status;
    }
    
    Scanner scanner = new Scanner(System.in);
    
    public void menu(Connection con) {
        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Terminate");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User user = new User(name, course, year, gender, id, password);
                    register(con, user);
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    String loginId = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    if(checkIdPassword(con, loginId, loginPassword)) {
                    	login(con, loginId, loginPassword);
                    	loginMenu(con);
                    }
                    break;
                case 3:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
    
    public void loginMenu(Connection con) {
        int choice;
        do {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. MyProjects");
            System.out.println("2. Create Project");
            System.out.println("3. Home");
            System.out.println("4. ShowPings");
            System.out.println("5. Ping Project");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    myProjects(con, currentUser);
                    System.out.println("1. Back");
                    scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 2:
                    createProjectMenu(con);
                    break;
                case 3:
                    home(con, currentUser);
                    System.out.println("1. Back");
                    scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 4:
                    showPings(con, currentUser);
                    System.out.println("1. Back");
                    scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 5:
                	System.out.print("Project ID: ");
                    int projectId = scanner.nextInt();
                    pingProject(con, currentUser, projectId);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
    
    public void createProjectMenu(Connection con) {
        System.out.print("Enter projectId: ");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter ownerId: ");
        String ownerId = scanner.nextLine();
        System.out.print("Enter requirement: ");
        String requirement = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        Project project = new Project(projectId, title, ownerId, requirement, description);
        createProject(con, project);
        
        System.out.println("1. Back");
        scanner.nextInt();
        scanner.nextLine();
    }
}






