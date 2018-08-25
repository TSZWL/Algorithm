package leetcode;

import java.util.*;

public class Solutionb403 {
	
	public static void main(String args[]){
		Solutionb403 s = new Solutionb403();
		int[] a = {0,1,2,3,4,8,9,11};
		System.out.println(s.canCross(a));
	}
	.
	public boolean canCross(int[] stones) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		map.put(0, new HashSet<>());
		map.get(0).add(0);
		for (int i = 1; i < stones.length; i ++)
			for (int j = 0; j < i; j ++)
				if (map.containsKey(j)) {
					Set<Integer> set = map.get(j);
					int x = stones[i] - stones[j];
					if (set.contains(x) || set.contains(x + 1) || set.contains(x - 1)) {
						if (!map.containsKey(i)) map.put(i, new HashSet<>());
						map.get(i).add(x);
					}
				}
		return map.containsKey(stones.length - 1);
	}
}