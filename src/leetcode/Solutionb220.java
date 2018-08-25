package leetcode;

import java.util.Map;
import java.util.HashMap;

public class Solutionb220 {
	
	public static void main(String args[]){
		Solutionb220 s = new Solutionb220();
		int[] a = {4, 2};
		System.out.println(s.containsNearbyAlmostDuplicate(a, 2, 1));
	}
	//map，余数
	//原本的取模运算占用了大量的时间
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		Map<Long,Long> m = new HashMap<Long,Long>();
		for (int i = 0; i < nums.length; i ++){
			if (i > k) m.remove(((long)nums[i - k - 1] - Integer.MIN_VALUE) / ((long)t + 1));
			long x = (long)nums[i] - Integer.MIN_VALUE;
			long a = x / ((long)t + 1);
			//long b = x % ((long)t + 1);
			if (m.containsKey(a)) return true;
			//b < m.get(a - 1)
			if (m.containsKey(a - 1) && x - m.get(a - 1) <= t) return true;
			if (m.containsKey(a + 1) && m.get(a + 1) - x <= t) return true;
			m.put(a, x);
		}
		return false;
	}
}