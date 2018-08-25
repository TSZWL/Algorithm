package leetcode;

import java.util.*;

class MyStack {

	Queue<Integer> f;
	/** Initialize your data structure here. */
	public MyStack() {
    	f = new LinkedList<Integer>();
	}
	
	/** Push element x onto stack. */
	public void push(int x) {
		int size = f.size();
		f.offer(x);
		for (int i = 0; i < size; i ++) f.offer(f.poll());
	}
	
	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return f.poll();
	}
	
	/** Get the top element. */
	public int top() {
		return f.peek();
	}
	
	/** Returns whether the stack is empty. */
	public boolean empty() {
		return f.isEmpty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */