package java8;

import java.util.Arrays;
import java.util.List;

public class StreamPractice {
	
	public static void twoX(int n) {
		System.out.print(2 * n);
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		list.forEach(element -> System.out.print(element));
		System.out.println();
		list.forEach(System.out::print);
		System.out.println();
		list.forEach(StreamPractice::twoX);
		
		System.out.println();
		System.out.print(list.stream().map(i -> i * 2).reduce(0, (result, value) -> result + value));
		
		System.out.println();
		int sumDivisibleBy2 = list.stream().filter(i -> i % 2 == 0).reduce(0, (result, value) -> result + value);
		System.out.print(sumDivisibleBy2);
		System.out.println();
		
		list.stream().limit(5).forEach(System.out::print);
	}

}
