package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb448 {
	
	public static void main(String args[]){
		Solutionb448 s = new Solutionb448();
		int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> x = s.findDisappearedNumbers(a);
		for (int i : x) System.out.println(i);
	}
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i ++)
			while ((nums[i] != i + 1) && (nums[i] != nums[nums[i] - 1])){
				int j = nums[i] - 1;
				nums[i] ^= nums[j];
				nums[j] ^= nums[i];
				nums[i] ^= nums[j];
			}
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] != i + 1) result.add(i + 1);
		return result;
	}
}