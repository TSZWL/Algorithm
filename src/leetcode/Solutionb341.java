package leetcode;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//根本不用压栈，用递归代替栈
//原来next()采用的删除元素的做法时间开销较大
abstract class NestedIterator implements Iterator<Integer> {

	Stack<Iterator<NestedInteger>> s;
	List<Integer> l;
	int index;
	public NestedIterator(List<NestedInteger> nestedList) {
		index = 0;
		s = new Stack<>();
		l = new ArrayList<>();
		Iterator<NestedInteger> it = nestedList.iterator();
		if (it.hasNext()) s.add(it); else return;
		while (!s.empty())
			if (it.hasNext()){
				NestedInteger x = it.next();
				if (x.isInteger()) l.add(x.getInteger());
				else {
					it = x.getList().iterator();
					s.add(it);
				}
			} else {
				s.pop();
				if (s.isEmpty()) return;
				it = s.peek();
			}
	}

	@Override
	public Integer next() {
		return l.get(index ++);
	}

	@Override
	public boolean hasNext() {
		if (l.size() <= index) return false;
		else return true;
	}
	

	interface NestedInteger {
	
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();
	
		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();
	
		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */