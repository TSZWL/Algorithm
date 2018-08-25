package leetcode;

import java.util.*;

public class Solution01 {
	public static void main(String args[]){
	}
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i ++){
			int l = target - nums[i];
			if (map.containsKey(l))	return new int[]{map.get(l), i};
			map.put(nums[i], i);
		}
		return null;
	}
}