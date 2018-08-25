package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solutionb436 {
	
	public static void main(String args[]){
	}
	//或者对开始节点进行基数排序。。 
	public int[] findRightInterval(Interval[] intervals) {
		int result[] = new int[intervals.length];
		if (intervals.length == 0) return result;
		for (int i = 0; i < intervals.length; i ++) result[i] = -1;
		int[][] f1 = new int[intervals.length][2];
		int[][] f2 = new int[intervals.length][2];
		for (int i = 0; i < intervals.length; i ++){
			f1[i][0] = intervals[i].start;
			f1[i][1] = i;
			f2[i][0] = intervals[i].end;
			f2[i][1] = i;
		}
		Arrays.sort(f1, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Arrays.sort(f2, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int head = 0, tail = 0;
		while (true){
			while (head < intervals.length && f1[head][0] < f2[tail][0]) head ++;
			if (head == intervals.length) return result;
			while (f2[tail][0] <= f1[head][0]){
				result[f2[tail][1]] = f1[head][1];
				tail ++;
			}
		}
	}
}