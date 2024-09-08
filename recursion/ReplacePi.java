package recursion;

import java.util.Scanner;

public class ReplacePi {
	
	/*
	 * Given a string, compute recursively a new string where 
	 * all appearances of "pi" have been replaced by "3.14".

		Constraints :
		1 <= |S| <= 50
		where |S| represents the length of string S. 
		Constraints :
		1 <= |S| <= 50
		where |S| represents the length of string S. 
		Sample Input 1 :
		xpix
		Sample Output 	:
		x3.14x
		Sample Input 2 :
		pipi
		Sample Output :
		3.143.14
		Sample Input 3 :
		pip
		Sample Output :
		3.14p
		Constraints:-
		1<=|S|<=50
	 */
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String replace(String input){
		return replace(input, 0);
	}

	private static String replace(String input, int start) {
		int n = input.length();
		if (start > n - 1) return "";
		if (start == n - 1) return input.charAt(n - 1) + "";

		String ans = "";
		if (input.charAt(start) == 'p' && input.charAt(start + 1) == 'i') {
			ans += "3.14";
			ans += replace(input, start + 2);
		} else {
			ans += input.charAt(start);
			ans += replace(input, start + 1);
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(replace(input));
	}

}
