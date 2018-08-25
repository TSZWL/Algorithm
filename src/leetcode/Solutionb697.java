package leetcode;

import java.util.Arrays;

public class Solutionb697 {
	
	public static void main(String args[]){
	}
	public int findShortestSubArray(int[] nums) {
		int[] n = new int[50000];
		int[] m = new int[50000];
		int[] f = new int[50000];
		Arrays.fill(n, -1);
		for (int i = 0; i < nums.length; i ++) {
			f[nums[i]] ++;
			if (n[nums[i]] == -1) n[nums[i]] = i;
			else m[nums[i]] = i - n[nums[i]];
		}
		int r = nums.length, x = 0;
		for (int i = 0; i < 50000; i ++) x = Math.max(x, f[i]);
		for (int i = 0; i < 50000; i ++)
			if (x == f[i]) r = Math.min(r, m[i]);
		return r + 1;
	}
}