package CollectionsImplementation;

import java.util.ArrayList;

public class ArrList {
	public static void show(ArrayList<Integer> arr) {
		for(Integer i : arr) {
			System.out.println(i);
		}
		
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		show(list);
 
		System.out.println(list.size());
	}
}
