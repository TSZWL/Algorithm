package leetcode;

public class Solution88 {
	public static void main(String args[]){
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m + n];
		int h1 = 0, h2 = 0, num = 0;
		while (h1 < m && h2 < n)
			if (nums1[h1] < nums2[h2]){
				result[num] = nums1[h1];
				num ++;
				h1 ++;
			} else {
				result[num] = nums2[h2];
				num ++;
				h2 ++;
			}
		for (int i = h1; i < m; i ++) result[n + i] = nums1[i];
		for (int i = h2; i < n; i ++) result[m + i] = nums2[i];
		for (int i = 0; i < m + n; i ++) nums1[i] = result[i];
	}
}