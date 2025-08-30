package java8;

import java.util.Arrays;
import java.util.List;

//Given a list of Person objects (with name and age fields), find the names of all people who are older than 30, sort them alphabetically, and return the result as a list.
//
//Input:
//
//Java
//
//class Person {
//    String name;
//    int age;
//    // constructor, getters
//}
//List<Person> people = Arrays.asList(
//    new Person("Alice", 25),
//    new Person("Bob", 35),
//    new Person("Charlie", 40),
//    new Person("David", 30)
//);
//Expected Output: ["Bob", "Charlie"]
//
//Hint: This problem requires chaining multiple operations: filter, map, and sorted. You'll need to define the Person class first.

public class ComplexFilteringAndMapping {
	
	public static List<String> mappedFilter(List<Person> list, int age){
		return list
				.stream()
				.filter(person -> person.getAge() > age)
				.map(person -> person.getName())
				.sorted()
				.toList();
	}
	
	
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
			    new Person("Alice", 25),
			    new Person("Bob", 35),
			    new Person("Charlie", 40),
			    new Person("David", 30)
			);
		
		
		mappedFilter(people, 30).forEach(System.out::println);
	}
}
