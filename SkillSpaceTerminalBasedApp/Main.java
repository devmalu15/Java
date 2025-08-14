package SkillSpaceTerminalBasedApp;

public class Main {
	public static void main(String[] args) {
		ISkillSpaceMethods obj = new SkillSpaceMethods();
		
		obj.menu(obj.connectDB());
		
	}

}
