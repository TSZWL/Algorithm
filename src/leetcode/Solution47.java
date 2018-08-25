package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
	
	public static void main(String args[]){
		Solution47 s = new Solution47();
		int[] a = {1, 2, 1};
		List<List<Integer>> x = s.permuteUnique(a);
		for (List<Integer> i : x){
			for (int j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> now = new ArrayList<Integer>();
	boolean[] b = new boolean[1001];
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		dfs(nums.length, 0, nums);
		return result;
	}
	private void dfs(int n, int x, int[] nums) {
		if (n == x){
			result.add(new ArrayList<>(now));
			return;
		}
		int select = -1;
		for (int i = 0; i < n; i ++)
			if ((!b[i]) && ((select == -1) || (nums[i] != nums[select]))){
				select = i;
				b[i] = true;
				now.add(nums[i]);
				dfs(n, x + 1, nums);
				b[i] = false;
				now.remove(now.size() - 1);
			}
	}
}