package java8;

import java.util.Arrays;
import java.util.List;

//Given a list of integers, filter out all the odd numbers and return a new list containing only the even numbers.
//
//Input: List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//Expected Output: [2, 4, 6, 8, 10]
//
//Hint: Use the filter and collect stream operations.


public class FilternignAndCollecting {
	public static List<Integer> filter(List<Integer> list){
		return list.stream().filter(element -> element % 2 == 0).toList();
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		filter(numbers).forEach(System.out::print);
	}
	
}
