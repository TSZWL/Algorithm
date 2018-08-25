package leetcode;

import java.util.*;

public class Solutionb347 {
	
	public static void main(String args[]){
		Solutionb347 s = new Solutionb347();
		int[] a = {1,1,1,2,2,3};
		List<Integer> r = s.topKFrequent(a, 2);
		for (int i : r) System.out.println(i);
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums.length == 0) return result;
		int[][] f = new int[nums.length][2];
		Arrays.sort(nums);
		int l = 1;
		f[0][0] = nums[0];
		f[0][1] = 1;
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] == nums[i - 1]) f[l - 1][1] ++;
			else {
				f[l][0] = nums[i];
				f[l ++][1] = 1;
			}
		Arrays.sort(f, 0, l, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return b[1] - a[1];
			}
		});
		for (int i = 0; i < k; i ++) result.add(f[i][0]);
		return result;
	}
}