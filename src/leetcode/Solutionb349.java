package leetcode;

import java.util.*;

public class Solutionb349 {
	public static void main(String args[]){
		Solutionb349 s = new Solutionb349();
		int[] a = {4,7,9,7,6,7};
		int[] b = {5,0,0,6,1,6,2,2,4};
		int[] r = s.intersection(a, b);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i]);
	}
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> result = new ArrayList<Integer>();
		int l1 = 0, l2 = 0;
		while (l1 < nums1.length && l2 < nums2.length){
			if (nums1[l1] < nums2[l2]){
				while (l1 < nums1.length && nums1[l1] < nums2[l2]) l1 ++;
			} else if (nums2[l2] < nums1[l1]){
				while (l2 < nums2.length && nums2[l2] < nums1[l1]) l2 ++;
			} else {
				result.add(nums1[l1]);
				do {l1 ++;} while (l1 < nums1.length && nums1[l1] == nums1[l1 - 1]);
				do {l2 ++;} while (l2 < nums2.length && nums2[l2] == nums2[l2 - 1]);
			}
		}
		int[] r = new int[result.size()];
		for (int i = 0; i < r.length; i ++) r[i] = result.get(i);
		return r;
	}
}