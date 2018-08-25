package leetcode;

import java.util.Arrays;

public class Solutionb561 {
	
	public static void main(String args[]){
		Solutionb561 s = new Solutionb561();
		int[] a = {1, 2, 4, 3};
		System.out.println(s.arrayPairSum(a));
	}
	//Õ∞≈≈–Ú…‘øÏ..
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < nums.length; i += 2) result += nums[i];
		return result;
	}
}