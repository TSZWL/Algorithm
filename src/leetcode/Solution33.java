package leetcode;

public class Solution33 {
	public static void main(String args[]){
		Solution33 s = new Solution33();
		int[] a = {3, 5, 1};
		System.out.println(s.search(a, 3));
	}
	public int search(int[] nums, int target) {
		int head = 0, tail = nums.length - 1;
		while (head <= tail){
			int mid = (head + tail) / 2;
			if (target == nums[mid]) return mid;
			if (nums[mid] < nums[head]){
				if (target > nums[mid] && target <= nums[tail]) head = mid + 1; else tail = mid - 1;
			} else if (nums[mid] > nums[tail]){
				if (target < nums[mid] && target >= nums[head]) tail = mid - 1; else head = mid + 1;
			} else {
				if (target < nums[mid]) tail = mid - 1; else head = mid + 1;
			}
		}
		return -1;
	}
}