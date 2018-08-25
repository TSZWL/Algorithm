package leetcode;

import java.util.*;

public class Solutionb435 {
	
	public static void main(String args[]){
	}
	public int eraseOverlapIntervals(Interval[] intervals) {
		Arrays.sort(intervals, (Interval a, Interval b) -> (a.end - b.end));
		int now = Integer.MIN_VALUE, num = 0;
		for (int i = 0; i < intervals.length; i ++)
			if (intervals[i].start >= now) {
				now = intervals[i].end;
				num ++;
			}
		return intervals.length - num;
	}
}