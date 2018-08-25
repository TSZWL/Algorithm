package leetcode;

public class Solution45 {
	
	public static void main(String args[]){
		Solution45 s = new Solution45();
		int[] a = {2, 3, 1, 1, 4};
		System.out.println(s.jump(a));
	}
	public int jump(int[] nums) {
		if (nums.length < 2) return 0;
		int min = nums[0], max = 0, step = 0;
		for (int i = 1; i < nums.length; i ++)
			if (i > min){
				min = max;
				max = i + nums[i];
				step ++;
			} else max = Math.max(max, i + nums[i]);
		return ++ step;
	}
}