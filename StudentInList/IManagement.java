package StudentInList;

public interface IManagement {
	public void addStudent(String name, int id, int age, String sec);
	public void sortByName();
	public void sortByAge();
	public void sortBySection();
	public void show();

}
