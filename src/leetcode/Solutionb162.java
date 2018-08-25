package leetcode;

public class Solutionb162 {
	
	public static void main(String args[]){
	}
	public int findPeakElement(int[] nums) {
		int head = 0, tail = nums.length - 1;
		while (head < tail - 1){
			int mid = (head + tail) / 2;
			if (nums[mid + 1] > nums[mid]) head = mid + 1;
			else if (nums[mid - 1] > nums[mid]) tail = mid - 1;
			else return mid;
		}
		return nums[head] < nums[tail] ? tail : head;
	}
}