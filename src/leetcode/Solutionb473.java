package leetcode;

import java.util.Arrays;

public class Solutionb473 {
	public static void main(String args[]){
		Solutionb473 s = new Solutionb473();
		int[] a = {3, 3, 2, 2, 2};
		System.out.println(s.makesquare(a));
	}
	public boolean makesquare(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i ++) sum += nums[i];
		if (sum % 4 != 0) return false;
		boolean[] use = new boolean[nums.length];
		return dfs(nums.length - 1, 0, 0, sum / 4, use, nums);
	}
	private boolean dfs(int start, int access, int now, int sum, boolean[] use, int[] nums) {
		if (now == sum){
			access ++;
			if (access == 4) return true;
			now = 0;
			start = nums.length - 1;
		}
		if (start < 0) return false;
		for (int i = start; i >= 0; i --)
			if ((!use[i]) && (now + nums[i] <= sum)){
				use[i] = true;
				if (dfs(i - 1, access, now + nums[i], sum, use, nums)) return true;
				use[i] = false;
			}
		return false;
	}
}