package java8;

import java.util.Arrays;
import java.util.List;

//Given a list of strings, convert each string to uppercase and return a new list of the transformed strings.
//
//Input: List<String> words = Arrays.asList("apple", "banana", "orange");
//
//Expected Output: ["APPLE", "BANANA", "ORANGE"]
//
//Hint: Use the map and collect stream operations.



public class MappingAndTransforming {
	public static List<String> transform(List<String> list) {
		return list.stream().map(str -> str.toUpperCase()).toList();
	}
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "orange");
		transform(words).forEach(System.out::println);
	}
}
