package leetcode;

public class Solution26 {
	
	public static void main(String args[]){
		Solution26 s = new Solution26();
		int[] a = {1, 1, 2, 2, 3, 4, 5, 5, 6};
		System.out.println(s.removeDuplicates(a));
	}
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0){
			return 0;
		}
		int num = 1;
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] != nums[i  - 1]){
				nums[num] = nums[i];
				num ++;
			}
		return num;
	}
}