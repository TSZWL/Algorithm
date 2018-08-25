package leetcode;

public class Solutionb153 {
	
	public static void main(String args[]){
		Solutionb153 s = new Solutionb153();
		int[] x = {4,5,6,7,0,1,2,3};
		System.out.println(s.findMin(x));
	}
	public int findMin(int[] nums) {
		int head = 0, tail = nums.length - 1;
		while (head < tail){
			if (nums[head] <= nums[tail]) return nums[head];
			int mid = (head + tail) / 2;
			if (nums[mid] > nums[tail]) head = mid + 1;
			else tail = mid;
		}
		return nums[head];
	}
}