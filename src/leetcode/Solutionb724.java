package leetcode;

public class Solutionb724 {
	
	public static void main(String args[]){
	}
	public int pivotIndex(int[] nums) {
		int tot = 0, now = 0;
		for (int i = 0; i < nums.length; i ++) tot += nums[i];
		for (int i = 0; i < nums.length; i ++) {
			if (now + nums[i] == tot - now) return i;
			now += nums[i];
		}
		return -1;
	}
}