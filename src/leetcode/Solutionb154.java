package leetcode;

public class Solutionb154 {
	
	public static void main(String args[]){
		Solutionb154 s = new Solutionb154();
		int[] x = {3,3,1,3};
		System.out.println(s.findMin(x));
	}
	//考虑到head=mid=tail的情况，dfs可能更优
	public int findMin(int[] nums) {
		int head = 0, tail = nums.length - 1;
		while (head < tail){
			if (nums[head] < nums[tail]) return nums[head];
			int mid = (head + tail) / 2;
			if (nums[mid] > nums[tail]) head = mid + 1;
			else if (nums[mid] < nums[tail]) tail = mid;
			else tail --;
		}
		return nums[head];
	}
}