package leetcode;

import java.util.*;

class MyQueue {

	Stack<Integer> f;
	/** Initialize your data structure here. */
	public MyQueue() {
		f = new Stack<>();
	}
	
	/** Push element x to the back of queue. */
	public void push(int x) {
		Stack<Integer> s = new Stack<>();
		int size = f.size();
		for (int i = 0; i < size; i ++) s.push(f.pop());
		f.push(x);
		for (int i = 0; i < size; i ++) f.push(s.pop());
	}
	
	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return f.pop();
	}
	
	/** Get the front element. */
	public int peek() {
		return f.peek();
	}
	
	/** Returns whether the queue is empty. */
	public boolean empty() {
		return f.isEmpty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */