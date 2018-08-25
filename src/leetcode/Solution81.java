package leetcode;

public class Solution81 {
	public static void main(String args[]){
		Solution81 s = new Solution81();
		int[] a = {1, 1, 3, 1};
		System.out.println(s.search(a, 3));
	}
	//the right part is sorted, and left part is unsorted
    //if (nums[mid] < nums[left] || nums[mid] < nums[right])
	public boolean search(int[] nums, int target) {
		int head = 0, tail = nums.length - 1;
		while (head <= tail){
			int mid = (head + tail) / 2;
			if (target == nums[mid]) return true;
			if (nums[mid] < nums[head]){
				if ((target > nums[mid]) && (target <= nums[tail])) head = mid + 1; else tail = mid - 1;
			} else if (nums[mid] > nums[tail]){
				if ((target < nums[mid]) && (target >= nums[head])) tail = mid - 1; else head = mid + 1;
			} else {
				if (nums[head] == nums[tail]){
					head ++;
					tail --;
					continue;
				}
				if (target < nums[mid]) tail = mid - 1; else head = mid + 1;
			}
		}
		return false;
	}
}