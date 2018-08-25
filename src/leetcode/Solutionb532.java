package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solutionb532 {
	
	public static void main(String args[]){
		Solutionb532 s = new Solutionb532();
		int[] a = {3, 1, 4, 1, 5};
		System.out.println(s.findPairs(a, 0));
	}
	public int findPairs(int[] nums, int k) {
		if (k < 0) return 0;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int result = 0;
		for (int i = 0; i < nums.length; i ++)
			if (!m.containsKey(nums[i])) m.put(nums[i], 1);
			else m.put(nums[i], m.get(nums[i]) + 1);
		if (k == 0){
			for (Iterator<Integer> i = m.keySet().iterator(); i.hasNext(); )
				if (m.get(i.next()) > 1) result ++;
			return result;
		}
		for (Iterator<Integer> i = m.keySet().iterator(); i.hasNext(); )
			if (m.containsKey(i.next() + k)) result ++;
		return result;
	}
}