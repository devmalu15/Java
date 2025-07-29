package ScoreManagement;

import java.util.ArrayList;

public class Main {
	
	public static void randomScores(int n, ArrayList<Integer> arr) {
		for(int i = 0; i < n; i++) {
			arr.add((int) (Math.random() * 100));
		}
	}
	
	public static void show(ArrayList<Integer> arr) {
		for(Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
	public static void topScores(ArrayList<Integer> arr) {
		int first = 0;
		int second = 0;
		int third = 0;
		
		for(Integer i : arr) {
			if(i > first) {
				first = i;
			}
			else if(i > second) {
				second = i;
			}
			else if(i > third) {
				third = i;
			}
			else {
				continue;
			}
		}
		
		System.out.println(first + " " + second + " " + third);
	}
	
	public static void removeFailing(ArrayList<Integer> arr) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) < 40) {
				arr.remove(i);
			}
			
		}
		
	}
	
	public static void editScores(ArrayList<Integer> arr) {
		for(Integer i : arr) {
			if(i < 50) {
				arr.set(arr.indexOf(i), 50);
			}
			else {
				continue;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> scores = new ArrayList<>();

		randomScores(100, scores);
		show(scores);
		topScores(scores);
//		editScores(scores);
//		show(scores);
		removeFailing(scores);
		show(scores);
		editScores(scores);
		show(scores);
	}

}
