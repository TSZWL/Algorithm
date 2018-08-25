package leetcode;

import java.util.Arrays;

public class Solutionb493 {
	
	public static void main(String args[]){
		Solutionb493 s = new Solutionb493();
		int[] a = {1, 3, 2, 3, 1};
		System.out.println(s.reversePairs(a));
	}
	//b315
	//line28 36去掉=(重要)
	//同315做法，速度会更快(加一个后段指针)
	public int reversePairs(int[] nums) {
		long[] list = new long[nums.length];
		for (int i = 0; i < nums.length; i ++) list[i] = (long)nums[i] * 2;
		Arrays.sort(list);
		int[] count = new int[nums.length];
		int result = 0;
		for (int i = nums.length - 1; i >= 0; i --) result += dfs(list, count, nums[i]);
		return result;
	}
	private int dfs(long[] list, int[] count, long val) {
		int sum = 0;
		int i = 0, j = list.length - 1;
		while (i <= j) {
			int m = (i + j) / 2;
			if (list[m] < val) {
				sum += count[m];
				i = m + 1;
			} else j = m - 1;
		}
		i = 0;j = list.length - 1;val *= 2;
		while (i <= j) {
			int m = (i + j) / 2;
			if (list[m] < val) {
				i = m + 1;
			} else {
				count[m] ++;
				j = m - 1;
			}
		}
		return sum;
	}
}