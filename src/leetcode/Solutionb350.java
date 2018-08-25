package leetcode;

import java.util.*;

public class Solutionb350 {
	
	public static void main(String args[]){
		Solutionb350 s = new Solutionb350();
		int[] a = {1,2,2,1};
		int[] b = {2,2};
		int[] r = s.intersect(a, b);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i]);
	}
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int l = 0, n = 0;
		int[] r = new int[nums1.length];
		for (int i = 0; i < nums1.length; i ++){
			while (l != nums2.length && nums2[l] < nums1[i]) l ++;
			if (l == nums2.length) break;
			if (nums2[l] == nums1[i]){
				r[n] = nums1[i];
				n ++;
				l ++;
			}
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i ++) result[i] = r[i];
		return result;
	}
}