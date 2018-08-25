package leetcode;

import java.util.*;

//���м�����룬�ֱ��������Ѽ�¼
//��Ϊ�����ʼ��ֻ�����м��������
//addNum����ϸ���жϿ��Լ���add�Ĵ������Ч��
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