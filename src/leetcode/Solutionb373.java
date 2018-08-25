package leetcode;

import java.util.*;

public class Solutionb373 {
	
	public static void main(String args[]){
		Solutionb373 s = new Solutionb373();
		int[] a = {1,2};
		int[] b = {3};
		List<int[]> r = s.kSmallestPairs(a, b, 3);
		for (int[] i : r) System.out.println(i[0] + " " + i[1]);
	}
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0) return result;
		Queue<int[]> q = new PriorityQueue<int[]>(nums1.length, (int[] a, int[] b) -> (a[0] - b[0]));
		for (int i = 0; i < nums1.length; i ++) q.add(new int[]{nums1[i] + nums2[0], i, 0});
		for (int i = 0; i < k; i ++) {
			int[] x = q.poll();
			result.add(new int[]{nums1[x[1]], nums2[x[2]]});
			if (++ x[2] < nums2.length) q.add(new int[]{nums1[x[1]] + nums2[x[2]], x[1], x[2]});
			if (q.isEmpty()) break;
		}
		return result;
	}
}