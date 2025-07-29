package StudentInList;

import java.util.ArrayList;

public class Management implements IManagement{
	
	ArrayList<Student> arrList = new ArrayList<>();
	
	@Override
	public void sortByName() {
		
		
	}
	
	@Override
	public void show() {
		for(Student i : arrList) {
			System.out.println(i.name + " ");
		}
		System.out.println();
		
	}

	@Override
	public void sortByAge() {
		 int n = arrList.size();
		 ArrayList<Student> result = new ArrayList<>();
		 result = arrList;
	        boolean swapped;

	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;

	            for (int j = 0; j < n - 1 - i; j++) {
	                if (result.get(j).age > result.get(j + 1).age) {
	                    Student temp = result.get(j);
	                    result.set(j, result.get(j + 1));
	                    result.set(j + 1, temp);
	                    swapped = true;
	                }
	            }

	            if (!swapped) {
	                break;
	            }
	        }
	        ((IManagement) result).show();
		
		
	}

	@Override
	public void sortBySection() {
		
		
		
	}

	@Override
	public void addStudent(String name, int id, int age, String sec) {
		Student student = new Student(name, id, age, sec);
		arrList.add(student);
	}
	
	
}
