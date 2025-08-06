package ExceptionHandling;

class RandomException extends RuntimeException{
	public RandomException(String str) {
		super(str);
	}
}

public class Demo {
	

	public static void main(String[] args) {
		int i = 10;
		int j = 11;
		int sum = 0;
		
		try {
			sum = i / j;
			if(sum == 0) {
				throw new RandomException("Random exception caught");
			}
		}
		catch(RandomException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Exception caught " + e.getMessage());
		}
		
		System.out.println(sum);
		
	
	}
		
	
}
