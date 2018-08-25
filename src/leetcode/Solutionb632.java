package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solutionb632 {
	
	public static void main(String args[]){
		Solutionb632 s = new Solutionb632();
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		nums.add(Arrays.asList(4, 10, 15, 24, 26));
		nums.add(Arrays.asList(0, 9, 12, 20));
		nums.add(Arrays.asList(5, 18, 22, 30));
		int[] r = s.smallestRange(nums);
		System.out.println(r[0]+" "+r[1]);
	}
	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<int[]> h = new PriorityQueue<int[]>(3501, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});  
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, j = 0;
		for (List<Integer> l : nums){
			int i = l.get(0);
			h.add(new int[]{i, j ++, 0});
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		int size = max - min, left = min, right = max;
		while (true){
			int[] n = h.poll();
			List<Integer> l = nums.get(n[1]);
			while (n[2] < l.size() && l.get(n[2]) == n[0]) n[2] ++;
			if (l.size() == n[2]) return new int[]{left, right};
			int newc = l.get(n[2]);
			h.add(new int[]{newc, n[1], n[2]});
			max = Math.max(max, newc);
			min = Math.max(min, h.peek()[0]);
			if (max - min < size){
				size = max - min;
				left = min;
				right = max;
			}
		}
	}
}