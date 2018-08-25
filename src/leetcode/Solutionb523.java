package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solutionb523 {
	public static void main(String args[]){
		Solutionb523 s = new Solutionb523();
		int[] a = {1, 2, 3};
		System.out.println(s.checkSubarraySum(a, 4));
	}
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		for (int i = 1; i < nums.length; i ++) nums[i] = nums[i] + nums[i - 1];
		if (k != 0)
			for (int i = 1; i < nums.length; i ++) nums[i] %= k;
		for (int i = 0; i < nums.length; i ++){
			Integer x = map.get(nums[i]);
			if (x != null){
				if (i - x > 1) return true;
			} else map.put(nums[i], i);
		}
		return false;
	}
}