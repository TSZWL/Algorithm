package leetcode;

public class Solutionb674 {
	
	public static void main(String args[]){
		Solutionb674 s = new Solutionb674();
		int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(s.findLengthOfLCIS(a));
	}
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0) return 0;
		int result = 1, now = 1;
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] > nums[i - 1]){
				now ++;
				result = Math.max(result, now);
			} else now = 1;
		return Math.max(result, now);
	}
}