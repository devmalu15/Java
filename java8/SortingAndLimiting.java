package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given a list of integers, sort the list in descending order and return the top 3 largest unique numbers.
//
//Input: List<Integer> numbers = Arrays.asList(5, 2, 8, 5, 1, 9, 8);
//
//Expected Output: [9, 8, 5]
//
//Hint: Use sorted, distinct, and limit to create the pipeline.

public class SortingAndLimiting {
	public static List<Integer> limitSort(List<Integer> list, int limit){
		return list
				.stream()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.limit(limit)
				.toList();
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 2, 8, 5, 1, 9, 8);
		
		limitSort(numbers, 3).forEach(System.out::print);
	}
}
