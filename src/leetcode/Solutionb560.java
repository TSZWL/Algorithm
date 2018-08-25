package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solutionb560 {
	public static void main(String args[]){
		Solutionb560 s = new Solutionb560();
		int[] a = {1, 1, 1};
		System.out.println(s.subarraySum(a, 2));
	}
	//hashmap提高效率，记录前面已有几个
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = 0;
		map.put(0, 1);
		for (int i = 1; i < nums.length; i ++) nums[i] += nums[i - 1];
		for (int i = 0; i < nums.length; i ++){
			Integer x = map.get(nums[i] - k);
			if (x != null) result += x;
			x = map.get(nums[i]);
			if (x == null) x = 0;
			map.put(nums[i], x + 1);
		}
		return result;
	}
}