package leetcode;

import java.util.Stack;

//O(1)~O(n)当前栈-最小栈
//最小栈优化队列->min值改变的时候把改变前的也压进去(变成单栈)
//MinStack.java
class MinStack {

	private Stack<Integer> s;
	private int min;
    /** initialize your data structure here. */
    public MinStack() {
    	s = new Stack<Integer>();
    	min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
    	if (x <= min){
    		s.add(min);
    		min = x;
    	}
    	s.add(x);
    }
    
    public void pop() {
    	if (s.pop() == min) min = s.pop();
    }
    
    public int top() {
    	return s.peek();
    }
    
    public int getMin() {
    	return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */