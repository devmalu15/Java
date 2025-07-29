package CollectionsImplementation;

import java.util.ArrayList;

public class ArrList {
	public static void show(ArrayList<Integer> arr) {
		for(Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		show(list);
		
		list.add(1, 5);
		show(list);
		
		System.out.println(list.get(1));
		
		list.set(1, 10);
		show(list);
		list.add(0);
		show(list);
		list.remove(0);
		show(list);
		
		
		
	}
}
