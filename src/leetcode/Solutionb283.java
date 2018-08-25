package leetcode;

public class Solutionb283 {
	
	public static void main(String args[]){
	}
	public void moveZeroes(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] != 0){
				nums[num] = nums[i];
				num ++;
			}
		for (int i = num; i < nums.length; i ++) nums[i] = 0;
	}
}