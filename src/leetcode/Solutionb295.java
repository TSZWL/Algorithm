package leetcode;

import java.util.*;

//在中间分两半，分别用两个堆记录
//因为需求的始终只有最中间的两个数
//addNum更详细的判断可以减少add的次数提高效率
class MedianFinder {

	Queue<Integer> large, small;
	/** initialize your data structure here. */
	public MedianFinder() {
		large = new PriorityQueue<Integer>();
		small = new PriorityQueue<Integer>(10001, new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
	}
    
	public void addNum(int num) {
		large.add(num);
		small.add(large.poll());
		if (large.size() < small.size()) large.add(small.poll());
	}
    
	public double findMedian() {
    	return large.size() == small.size() ? (large.peek() + small.peek()) / 2.0 : large.peek();
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */