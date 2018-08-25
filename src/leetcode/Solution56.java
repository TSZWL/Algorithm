package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Solution56 {
	
	public static void main(String args[]){
	}
	//端点排序+类似括号处理
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) return result;
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int start = intervals.get(0).start, end = intervals.get(0).end;
		for (Interval i : intervals){
			if (i.start > end){
				result.add(new Interval(start, end));
				start = i.start;
				end = i.end;
			} else {
				end = Math.max(end, i.end);
			}
		}
		result.add(new Interval(start, end));
		return result;
	}
}