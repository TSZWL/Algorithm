package leetcode;

import java.util.*;

public class Solution17 {
	public static void main(String args[]){
		Solution17 s = new Solution17();
		int[] a = {1,0,-1,0,-2,2};
		List<List<Integer>> r = s.fourSum(a, 0);
		for (List<Integer> l : r){
			for (int i : l) System.out.print(i + " ");
			System.out.println();
		}
	}
	//可以循环前两个然后后两个从两边到中间
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> now = new ArrayList<Integer>();
	Set<Integer> set = new HashSet<Integer>();
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums.length < 4) return result;
		int[] max = new int[5];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i ++) set.add(nums[i]);
		for (int i = 1; i < 5; i ++) max[i] = max[i - 1] + nums[nums.length - i];
		dfs(0, 4, nums, 0, target, max);
		return result;
	}
	private void dfs(int j, int l, int[] nums, int sum, int target, int[] max) {
		if (sum + nums[j] * l > target) return;
		if (sum + max[l] < target) return;
		if (l == 1){
			if (set.contains(target - sum)){
				now.add(target - sum);
				result.add(new ArrayList<Integer>(now));
				now.remove(3);
			}
			return;
		}
		for (int i = j; i <= nums.length - l; i ++){
			now.add(nums[i]);
			dfs(i + 1, l - 1, nums, sum + nums[i], target, max);
			now.remove(now.size() - 1);
			while (i < nums.length - 1 && nums[i] == nums[i + 1]) i ++;
		}
	}
}