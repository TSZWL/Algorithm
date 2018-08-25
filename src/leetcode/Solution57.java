package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
	
	public static void main(String args[]){
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		int min = newInterval.start, max = newInterval.end;
		boolean d = false;
		for (Interval i : intervals){
			int a = i.start, b = i.end;
			if (!d && b >= min && a <= max){
				min = Math.min(min, a);
				max = Math.max(max, b);
			} else{
				if (!d && a > max){
					result.add(new Interval(min, max));
					d = true;
				}
				result.add(i);
			}
		}
		if (!d) result.add(new Interval(min, max));
		return result;
	}
}