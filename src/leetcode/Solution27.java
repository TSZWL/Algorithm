package leetcode;

public class Solution27 {
	
	public static void main(String args[]){
		Solution27 s = new Solution27();
		int[] a = {3, 2, 2 ,3};
		System.out.println(s.removeElement(a, 3));
	}
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0){
			return 0;
		}
		int num = 0;
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] != val){
				nums[num] = nums[i];
				num ++;
			}
		return num;
	}
}