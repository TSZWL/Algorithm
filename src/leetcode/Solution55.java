package leetcode;

public class Solution55 {
	
	public static void main(String args[]){
		Solution55 s = new Solution55();
		int[] a = {3,2,1,0,4};
		System.out.println(s.canJump(a));
	}
	public boolean canJump(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i ++)
			if (max >= i){
				max = Math.max(max, i + nums[i]);
				if (max >= nums.length - 1) return true;
			} else return false;
		return true;
	}
}