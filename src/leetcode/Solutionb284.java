package leetcode;

import java.util.*;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	//不用这么麻烦，直接记录前一位为pre即可
	private Integer next = null;
	private Iterator<Integer> iterator = null;
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (next != null) return next;
		else {
			next = iterator.next();
			return next;
		}
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (next != null){
			Integer result = next;
			next = null;
			return result;
		} else return iterator.next();
	}

	@Override
	public boolean hasNext() {
		if (next != null) return true;
		else return iterator.hasNext();
	}

	public void remove() {
	}
}