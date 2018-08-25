package leetcode;

import java.util.*;

public class Solutionb506 {
	
	public static void main(String args[]){
	}
	//Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
	public String[] findRelativeRanks(int[] nums) {
		String[] result = new String[nums.length];
		int[][] f = new int[nums.length][2];
		for (int i = 0; i < f.length; i ++){
			f[i][0] = nums[i];
			f[i][1] = i;
		}
		Arrays.sort(f, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return b[0] - a[0];
			}
		});
		if (f.length > 0) result[f[0][1]] = "Gold Medal";
		if (f.length > 1) result[f[1][1]] = "Silver Medal";
		if (f.length > 2) result[f[2][1]] = "Bronze Medal";
		for (int i = 3; i < f.length; i ++) result[f[i][1]] = i + 1 + "";
		return result;
	}
}