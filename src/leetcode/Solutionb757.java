package leetcode;

import java.util.Arrays;

public class Solutionb757 {
	
	public static void main(String args[]){
		Solutionb757 s = new Solutionb757();
		int[][] a = {{33,44},{42,43},{13,37},{24,33},{24,33},{25,48},{10,47},{18,24},{29,37},{7,34}};
		System.out.println(s.intersectionSizeTwo(a));
	}
	//贪心 能放2个和能放1个的区别处理
	public int intersectionSizeTwo(int[][] intervals) {
		int head = 0, l = intervals.length, tot = 0;
		Arrays.sort(intervals, (int[] a, int[] b) -> (a[1] - b[1]));
		int[][] i2 = new int[l][2];
		for (int i = 0; i < l; i ++) {
			i2[i][0] = intervals[i][0];
			i2[i][1] = i;
		}
		Arrays.sort(i2, (int[] a, int[] b) -> (a[0] - b[0]));
		int[] b = new int[l];
		for (int i = 0; i < l; i ++)
			if (b[i] < 2) {
				tot += 2 - b[i];
				if (b[i] == 0)
					while (head < l && i2[head][0] < intervals[i][1]) b[i2[head ++][1]] += 2;
				int now = head;
				while (now < l && i2[now][0] <= intervals[i][1]) b[i2[now ++][1]] += 1;
			}
		return tot;
	}
}