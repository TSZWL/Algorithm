package leetcode;

public class Solution35 {
	public static void main(String args[]){
		Solution35 s = new Solution35();
		int[] a = {1, 3, 4};
		System.out.println(s.searchInsert(a, 4));
	}
	//¶þ·Ö...
	public int searchInsert(int[] nums, int target) {
		int result = 0;
		while ((result < nums.length) && (nums[result] < target)) result ++;
		return result;
	}
}