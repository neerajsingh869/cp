package recursion;

import java.util.Scanner;

public class RemoveDuplicates {
	
	/*
	 * Given a string S, remove consecutive duplicates from it recursively.

		Detailed explanation ( Input/output format, Notes, Images )
		Input Format :
		String S
		Output Format :
		Output string
		Constraints :
		1 <= |S| <= 10^3
		where |S| represents the length of string
		Sample Input 1 :
		aabccba
		Sample Output 1 :
		abcba
		Sample Input 2 :
		xxxyyyzwwzzz
		Sample Output 2 :
		xyzwz
	 */
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String removeConsecutiveDuplicates(String s) {
		return removeConsecutiveDuplicates(s, 0);
	}

	private static String removeConsecutiveDuplicates(String s, int start) {
		int n = s.length();
		if (start > n - 1) return "";
		if (start == n - 1) return s.charAt(start) + "";

		String ans = "";
		if (s.charAt(start) == s.charAt(start + 1)) {
			ans += removeConsecutiveDuplicates(s, start + 1);
		} else {
			ans += s.charAt(start) + removeConsecutiveDuplicates(s, start + 1);
		}

		return ans;
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
    	String input = s.next();
    	System.out.println(removeConsecutiveDuplicates(input));
    }

}
