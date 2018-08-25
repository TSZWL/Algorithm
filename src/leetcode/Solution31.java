package leetcode;

import java.util.Arrays;

public class Solution31 {
	
	public static void main(String args[]){
	}
	public void nextPermutation(int[] nums) {
		int l = nums.length - 1;
		if (l <= 0) return;
		int i = 0;
		for (i = l - 1; i >= 0; i --)
			if (nums[i] < nums[i + 1]) break;
		if (i == -1){
			Arrays.sort(nums);
			return;
		}
		for (int j = l; j >= 0; j --)
			if (nums[j] > nums[i]){
				nums[j] ^= nums[i];
				nums[i] ^= nums[j];
				nums[j] ^= nums[i];
				break;
			}
		Arrays.sort(nums, i + 1, nums.length);
	}
}