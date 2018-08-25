package leetcode;

public class Solution80 {
	
	public static void main(String args[]){
		Solution80 s = new Solution80();
		int[] a = {1, 1, 1, 2, 2, 3};
		System.out.println(s.removeDuplicates(a));
	}
	public int removeDuplicates(int[] nums) {
		int now = 2;
		for (int i = 2; i < nums.length; i ++)
			if (nums[i] != nums[now - 2]){
				nums[now] = nums[i];
				now ++;
			}
		return now;
	}
}