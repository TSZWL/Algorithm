package leetcode;

public class Solutionb169 {
	
	public static void main(String args[]){
	}
	//+1 -1的方法?  重点.>超过
	public int majorityElement(int[] nums) {
		int n = nums[0], c = 1;
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] != n){
				c --;
				if (c < 0){
					n = nums[i];
					c = 1;
				}
			} else c ++;
		return n;
	}
}