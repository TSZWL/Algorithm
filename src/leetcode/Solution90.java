package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
	
	public static void main(String args[]){
		Solution90 s = new Solution90();
		int[] nums = {1, 2, 2};
		List<List<Integer>> x = s.subsetsWithDup(nums);
		for (List<Integer> i : x){
			for (int j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> n = new ArrayList<Integer>();
		if (nums.length == 0){
			result.add(n);
			return result;
		}
		Arrays.sort(nums);
		int[] now = new int[nums.length];
		int[] c = new int[nums.length];
		int j = 0, l = 1;
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] != nums[i - 1]){
				now[j] = nums[i - 1];
				c[j] = l;
				l = 1;
				j ++;
			} else l ++;
		now[j] = nums[nums.length - 1];
		c[j] = l;
		dfs(0, j, result, n, now, c);
		return result;
	}
	private void dfs(int j, int l, List<List<Integer>> result, List<Integer> n, int[] now, int[] c) {
		if (j > l){
			List<Integer> x = new ArrayList<Integer>(n);
			result.add(x);
			return;
		}
		for (int i = 0; i <= c[j]; i ++){
			dfs(j + 1, l, result, n, now, c);
			n.add(now[j]);
		}
		for (int i = 0; i <= c[j]; i ++) n.remove(n.size() - 1);
	}
}