package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb228 {
	public static void main(String args[]){
		Solutionb228 s = new Solutionb228();
		int[] a = {0, 1, 2, 4, 5, 7};
		List<String> r = s.summaryRanges(a);
		for (String x : r) System.out.println(x);
	}
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums.length == 0) return result;
		int start = nums[0];
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] != nums[i - 1] + 1){
				if (nums[i - 1] == start) result.add(start + "");
				else result.add(start + "->" + nums[i - 1]);
				start = nums[i];
			}
		if (nums[nums.length - 1] == start) result.add(start + "");
		else result.add(start + "->" + nums[nums.length - 1]);
		return result;
	}
}