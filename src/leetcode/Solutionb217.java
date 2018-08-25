package leetcode;

import java.util.Arrays;

public class Solutionb217 {
	
	public static void main(String args[]){
		Solutionb217 s = new Solutionb217();
		int[] a = {1, 1};
		System.out.println(s.containsDuplicate(a));
	}
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i ++)
			if (nums[i] == nums[i + 1]) return true;
		return false;
	}
}