package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb442 {
	
	public static void main(String args[]){
		Solutionb442 s = new Solutionb442();
		int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> x = s.findDuplicates(a);
		for (int i : x) System.out.println(i);
	}
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i ++)
			while ((nums[i] != i + 1) && (nums[i] != nums[nums[i] - 1])){
				int j = nums[i] - 1;
				nums[i] ^= nums[j];
				nums[j] ^= nums[i];
				nums[i] ^= nums[j];
			}
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] != i + 1) result.add(nums[i]);
		return result;
	}
}