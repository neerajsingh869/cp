package collections;

import java.util.Stack;

public class LearnStack {

	public static void main(String[] args) {
		// create a stack
		Stack<Integer> stack = new Stack<>();
		
		// pushing element on top of the stack (O(1))
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println(stack);
		
		// size of the stack (O(1))
		System.out.println(stack.size());
		
		// printing the top element of the stack (O(1))
		System.out.println(stack.peek());
		
		// poping element from the stack (O(1))
		stack.pop();
		System.out.println(stack.peek());
		
		// searching element in the stack (O(n))
		stack.push(50);
		stack.push(100);
		System.out.println(stack);
		System.out.println(stack.search(20));
		System.out.println(stack.search(200));
		
		// checking if stack is empty (O(1))
		System.out.println(stack.isEmpty());
	}

}
