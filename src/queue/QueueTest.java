package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		System.out.println(q.toString());
		q.poll();
		System.out.println(q.peek());
		System.out.println(q.toString());
	}
}
