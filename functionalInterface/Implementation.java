package functionalInterface;

import java.util.Scanner;

public class Implementation{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		Inter obj = (int a, int b) -> {
			
			return a + b;
		};
		
		obj.sum(num1, num2);
	}
}
