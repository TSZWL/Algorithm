package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
	
	public static void main(String args[]){
		Solution46 s = new Solution46();
		int[] a = {1, 2, 3};
		List<List<Integer>> x = s.permute(a);
		for (List<Integer> i : x){
			for (int j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> now = new ArrayList<Integer>();
	boolean[] b = new boolean[1001];
	public List<List<Integer>> permute(int[] nums) {
		dfs(nums.length, 0, nums);
		return result;
	}
	private void dfs(int n, int x, int[] nums) {
		if (n == x){
			result.add(new ArrayList<>(now));
			return;
		}
		for (int i = 0; i < n; i ++)
			if (!b[i]){
				b[i] = true;
				now.add(nums[i]);
				dfs(n, x + 1, nums);
				b[i] = false;
				now.remove(now.size() - 1);
			}
	}
}