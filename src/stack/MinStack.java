package stack;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		// do initialize if necessary
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int number) {
		// write your code here
		if (stack.isEmpty()) {
			stack.push(number);
			minStack.push(number);
		} else {
			int min = Math.min(minStack.peek(), number);
			stack.push(number);
			minStack.push(min);
		}
	}

	public int pop() {
		// write your code here
		minStack.pop();
		return stack.pop();
	}

	public int min() {
		// write your code here
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(1);
		System.out.println(ms.pop());
		ms.push(2);
		ms.push(3);
		System.out.println(ms.min());
		ms.push(1);
		System.out.println(ms.min());
	}
}
