package collections;

import java.util.LinkedList;
import java.util.Queue;

public class LearnQueue {

	public static void main(String[] str) {
		// initialize queue
		Queue<Integer> queue = new LinkedList<>();
		
		// add element to the queue (O(1))
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		System.out.println(queue);
		
		// print the head element of the queue (O(1))
		System.out.println(queue.peek());
		
		// remove the head element of the queue (O(1))
		System.out.println(queue.remove());
		
		// size of the queue (O(1))
		System.out.println(queue.size());
		
		// check if queue is empty (O(1))
		System.out.println(queue.isEmpty());
	}

}
