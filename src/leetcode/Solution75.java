package leetcode;

public class Solution75 {
	
	public static void main(String args[]){
	}
	public void sortColors(int[] nums) {
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] == 0){
				nums[a ++] = 2;
				nums[b ++] = 1;
				nums[c ++] = 0;
			} else if (nums[i] == 1){
				nums[a ++] = 2;
				nums[b ++] = 1;
			} else nums[a ++] = 2;
	}
}