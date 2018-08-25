package leetcode;

import java.util.Arrays;

public class Solutionb452 {
	
	public static void main(String args[]){
		Solutionb452 s = new Solutionb452();
		int[][] a = {{10,16}, {2,8}, {1,6}, {7,12}};
		System.out.println(s.findMinArrowShots(a));
	}
	//不用按照开始坐标排序
	//按照结束坐标排序后，后一个已经被扎过的话，那么它一定可以被紧挨着的前一个扎到(改进b757
	public int findMinArrowShots(int[][] points) {
		int l = points.length;
		if (l == 0) return 0;
		Arrays.sort(points, (int[] a, int[] b) -> (a[1] - b[1]));
		int last = points[0][1], ans = 1;
		for (int i = 1; i < l; i ++)
			if (last < points[i][0]) {
				last = points[i][1];
				ans ++;
			}
		return ans;
	}
}