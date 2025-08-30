package java8;

import java.util.Arrays;
import java.util.List;

//Given a list of integers, find the sum of all the numbers.
//
//Input: List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
//
//Expected Output: 150
//
//Hint: Use the reduce or sum terminal operation.

public class AggregateAndReduction {
	public static int aggregate(List<Integer> list){
		return list.stream().reduce(0, (result, element) -> result + element);
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
		
		System.out.print(aggregate(numbers));
	}
}
