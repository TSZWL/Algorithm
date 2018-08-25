package leetcode;

public class Solutionb665 {
	
	public static void main(String args[]){
	}
	public boolean checkPossibility(int[] nums) {
		int k = 0, now = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i ++) 
			if (nums[i] < now) {
				if (k == 1) return false;
				k = 1;
				if (i < 2 || nums[i] >= nums[i - 2]) now = nums[i];
			} else now = nums[i];
		return true;
	}
}