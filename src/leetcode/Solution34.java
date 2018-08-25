package leetcode;

public class Solution34 {
	public static void main(String args[]){
		Solution34 s = new Solution34();
		int[] a = {4};
		int[] b = s.searchRange(a, 4);
		System.out.println(b[0] + " " + b[1]);
	}
	//long
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) return new int[]{-1, -1};
		int[] result = new int[2];
		int head = 0, tail = nums.length - 1;
		while (head < tail){
			int mid = (head + tail) / 2;
			if (nums[mid] < target) head = mid + 1; else tail = mid;
		}
		if (nums[head] != target) return new int[]{-1, -1};
		result[0] = head;
		tail = nums.length - 1;
		while (head < tail){
			int mid = (head + tail) / 2 + 1;
			if (nums[mid] == target) head = mid; else tail = mid - 1;
		}
		result[1] = head;
		return result;
	}
}