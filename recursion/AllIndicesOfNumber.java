package recursion;

import java.util.Scanner;

public class AllIndicesOfNumber {
	
	/*
	 * Given an array of length N and an integer x, you need 
	 * to find all the indexes where x is present in the 
	 * input array. Save all the indexes in an array (in increasing order).

		Do this recursively. Indexing in the array starts from 0.
		
		Detailed explanation ( Input/output format, Notes, Images )
		Input Format :
		Line 1 : An Integer N i.e. size of array
		Line 2 : N integers which are elements of the array, separated by spaces
		Line 3 : Integer x
		Output Format :
		indexes where x is present in the array (separated by space)
		Constraints :
		1 <= N <= 10^3
		
		Sample Input :
		5
		9 8 10 8 8
		8
		Sample Output :
		1 3 4
	 */
	// Time complexity -> O(n*n), Space complexity -> O(n*n)
	public static int[] findIndices(int[] input, int x) {
		return findIndices(input, x, 0);
	}

	public static int[] findIndices(int[] input, int x, int start) {
		int n = input.length;
		if (start > n - 1) return new int[0];

		int[] smallAns = findIndices(input, x, start + 1);

		if (input[start] == x) {
			int[] ans = new int[smallAns.length + 1];
			ans[0] = start;
			for (int i = 0; i < smallAns.length; i++) {
				ans[i + 1] = smallAns[i];
			}

			return ans;
		}

		return smallAns;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		int x = sc.nextInt();

		int[] output = findIndices(input, x);

		printOutput(output);
	}
	
	public static void printOutput(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
