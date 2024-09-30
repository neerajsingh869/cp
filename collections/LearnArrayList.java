package collections;

import java.util.*;

public class LearnArrayList {
	
	public static void main(String[] args) {
		// constructor to build empty arraylist
		ArrayList<Integer> list1 = new ArrayList<>();
		System.out.println(list1);
		
		// constructor to build arraylist with capacity 100
		ArrayList<Integer> list2 = new ArrayList<>(100);
		System.out.println(list2);
		
		// arraylist with 10 elements all equal to 0
		ArrayList<Integer> list3 = new ArrayList<>(Collections.nCopies(10, 0));
		System.out.println(list3);
		
		System.out.println("--".repeat(20));
		
		// add in arraylist (O(1) -> amortized)
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		list3.add(10);
		list3.add(20);
		list3.add(30);
		System.out.println(list1);
		System.out.println(list3);
		
		System.out.println("--".repeat(20));
		
		// get in arraylist (O(1))
		System.out.println(list1.get(1));
		System.out.println(list3.get(1));
		
		System.out.println("--".repeat(20));
		
		// add elements in between arraylist (O(n))
		list1.add(1, 100);
		
		list3.add(1, 1000);
		System.out.println(list1);
		System.out.println(list3);
		
		System.out.println("--".repeat(20));
		
		// set element in arraylist (O(1))
		list1.set(0, 0);
		
		list3.set(0, 0);
		System.out.println(list1);
		System.out.println(list3);
		
		System.out.println("--".repeat(20));
		
		// delete/modify in arraylist (O(n))
		list1.remove(2);
		
		list3.remove(2);
		System.out.println(list1);
		System.out.println(list3);
		
		System.out.println("--".repeat(20));
		
		// size of arraylist (O(1))
		System.out.println(list1.size());
		System.out.println(list3.size());
		
		// sort arraylist (O(n*log(n)))
		Collections.sort(list1);
		Collections.sort(list3);
		System.out.println(list1);
		System.out.println(list3);
		
		System.out.println("--".repeat(20));
		
		// clear the element from arraylist (O(n))
		list1.clear();
		
		list3.clear();
		System.out.println(list1);
		System.out.println(list3);
		
	}

}
