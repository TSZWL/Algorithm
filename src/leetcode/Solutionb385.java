package leetcode;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
	int tail;
	public NestedInteger deserialize(String s) {
		tail = 0;
		char[] c = s.toCharArray();
		if (c[tail] == '[') return dfs(c);
		else {
			int x = 0, y = 1;
			if (c[tail] == '-'){
				tail ++;
				y = -1;
			}
			while (tail < c.length){
				x = x * 10 + c[tail] - '0';
				tail ++;
			}
			return new NestedInteger(x * y);
		}
	}
	
	private NestedInteger dfs(char[] c) {
		tail ++;
		NestedInteger r = new NestedInteger();
		while (c[tail] != ']'){
			if (c[tail] == '[') r.add(dfs(c));
			else {
				int x = 0, y = 1;
				if (c[tail] == '-'){
					tail ++;
					y = -1;
				}
				while (c[tail] >= '0' && c[tail] <= '9'){
					x = x * 10 + c[tail] - '0';
					tail ++;
				}
				r.add(new NestedInteger(x * y));
			}
			if (c[tail] == ',') tail ++;
		}
		tail ++;
		return r;
	}

	class NestedInteger {
		// Constructor initializes an empty nested list.
		public NestedInteger(){};
		
		// Constructor initializes a single integer.
		public NestedInteger(int value){};
		
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger(){ return false; };
		
		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger(){ return 0; };
		
		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value){};
		
		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni){};
		
		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList(){ return null; };
	}
}