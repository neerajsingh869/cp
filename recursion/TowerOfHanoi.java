package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
	
	/*
		You are given three rods (numbered 1 to 3), and ‘N’ disks 
		initially placed on the first rod, one on top of each other 
		in increasing order of size ( the largest disk is at the bottom). 
		You are supposed to move the ‘N’ disks to another rod(either rod 2 or rod 3)
		 using the following rules and in less than 2 ^ (N) moves.
		
		1. You can only move one disk in one move. 
		2. You can not place a larger disk on top of a smaller disk.
		3. You can only move the disk at the top of any rod.    
		Note :
		You may assume that initially, the size of the ‘i’th 
		disk from the top of the stack is equal to ‘i’, i.e. 
		the disk at the bottom has size ‘N’, the disk above 
		that has size ‘N - 1’, and so on. The disk at the top 
		has size 1.
		
		Detailed explanation ( Input/output format, Notes, Images )
		Input Format :
		The first line contains a single integer ‘T’ denoting 
		the number of test cases. The test cases follow.
		
		The first line of each test case contains a single 
		integer ‘N’ denoting the number disks.
		Output Format :
		For each test case, return a 2-D array/list, where 
		each row of the array should contain exactly two integers. 
		The first integer should be the number of the rod from where 
		the topmost disk is to be removed and the second integer 
		should denote the number of the rod where the removed disk 
		is to be placed. If you have correctly moved all the disks 
		from rod 1 to either rod 2 or rod 3 the output will be ‘1’ 
		otherwise the output will be ‘0’.
		
		The output of every test case will be printed in a 
		separate line.
		Note :
		You don’t need to print anything; It has already been taken care of.
		Constraints :
		1 <= T <= 5
		1 <= N <= 12
		
		Where ‘T’ denotes the number of test cases, ‘N’ denotes 
		the number of disks.
		
		Time Limit: 1 sec
		Sample Input 1 :
		2
		1
		2
		Sample Output 1 :
		1
		1
		Explanation of Sample Input 1 :
		In the first test case, 
		you can move the only disk to either rod 2 or rod 3. 
		The matrix to be returned should be either { { 1, 2 } } or { {1, 3 } }.
		
		In the second test case, 
		you can move the topmost disk from rod 1 to rod 2. 
		Then move the remaining disk from rod1 to rod 3. 
		Now move the disk in rod 2 to rod 3. . One of the 
		correct ways to return the output is { { 1, 2 }, { 1, 3 }, { 2, 3 } }.  
		Sample Input 2 :
		1
		3
		Sample Output 2 :
		1
		Explanation of Sample Input 2 :
		One of the correct matrices is { { 1, 2 }, { 1, 3 }, 
		{ 2, 3 }, { 1, 2 }, { 3, 1 }, { 3, 2 }, { 1, 2 } }.
	 */
	// Time complexity -> O(2^n), Space complexity -> O(n)
	public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n) 
    {
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
        towerOfHanoi(n, 1, 2, 3, moves);

        return moves;
    }

    public static void towerOfHanoi(int n, int source, int auxiliary, int destination, ArrayList<ArrayList<Integer>> moves) {
        if (n == 0) return;

        towerOfHanoi(n - 1, source, destination, auxiliary, moves);

        moves.add(new ArrayList<Integer>(Arrays.asList(source, destination)));

        towerOfHanoi(n - 1, auxiliary, source, destination, moves);
    }
    
    private static int t;
    private static ArrayList<Integer> arr;

    private static void takeInput() throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine().split(" ")[0]);

        arr = new ArrayList<Integer>(t);

        String []data;

        for (int i = 0; i < t; i++)
        {
            data = br.readLine().split(" ");

            arr.add(Integer.parseInt(data[0]));
        }
    }

    private static boolean checker(ArrayList<ArrayList<Integer>> v, int n)
    {
    	@SuppressWarnings("unchecked")
		ArrayList<Integer> []a = new ArrayList[3];
        //  push all the disks to the first rod.

        for(int i=0 ;i <3; i ++)
        {
            a[i] = new ArrayList<Integer>();
        }

        for (int i = n; i >= 1; i--)
        {
            a[0].add(i);
        }

        int sz = n;

        //    If there are more than 2^n -1 moves return false.
        if (v.size() >= (1 << n))
        {
            System.out.println("No of moves exceeded");
            return false;
        }

        for (int i = 0; i < v.size(); i++)
        {    
            //    if one move has more than 3 integers return false
            if (v.get(i).size() != 2)
            {
                System.out.println("Using more than 2 disks in one move");
                return false;
            }

            int to = v.get(i).get(1);
            int from = v.get(i).get(0);

            //  If Rod number lies out of range return false.
            if (to <= 0 || from <= 0)
            {
                System.out.println("Invalid rod number ");

                return false;
            }

            //  If Rod number lies out of range return false.
            if (to > 3 || from > 3)
            {
                System.out.println("Invalid rod number ");

                return false;
            }

            //  0 based indexing
            to--;
            from--;

            //    If there is no disk on the rod return false.
            if (a[from].isEmpty())
            {
                System.out.println("Removing disk from empty rod");
                return false;
            }

            int last = a[from].get(a[from].size()-1);
            a[from].remove(a[from].size()-1);

            //    If the disk can be placed on the required rod.
            if (a[to].isEmpty() || a[to].get(a[to].size()-1) > last)
            {
                a[to].add(last);
            }
            //    Return false if the disk is placed on a smaller disk
            else
            {
                System.out.println("Placing a larger disk on a smaller disk");
                return false;
            }
        }

        //    Return true if rod 2 or rod 3 has N disks.
        return (a[1].size() == n || a[2].size() == n);
    }

    private static void execute() 
    {
        ArrayList<Integer> arrCopy = new ArrayList<Integer>(arr);

        for (int i = 0; i < t; i++) 
        {
            ArrayList<ArrayList<Integer>> ans = towerOfHanoi(arrCopy.get(i));
        }
    }

    private static void executeAndPrintOutput() 
    {
        for (int i = 0; i < t; i++) 
        {
            int temp = arr.get(i);

            ArrayList<ArrayList<Integer>> ans = towerOfHanoi(arr.get(i));

            if(checker(ans, temp))
            {
                System.out.println("1");
            }
            else
            {
                System.out.println("0");
            }
        }
    }
  
    public static void main(String[] args) throws IOException 
    {
        takeInput();

        executeAndPrintOutput();
    }
	
}
