package leetcode;

public class Solution53 {
	
	public static void main(String args[]){
		Solution53 s = new Solution53();
		int[] x = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(s.maxSubArray(x));
	}
	public int maxSubArray(int[] nums) {
		int min = 0, now = 0, result = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i ++){
			now += nums[i];
			if (now - min > result) result = now - min;
			if (now < min) min = now;
		}
		return result;
	}
}