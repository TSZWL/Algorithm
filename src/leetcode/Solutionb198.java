package leetcode;

public class Solutionb198 {
	
	public static void main(String args[]){
		Solutionb198 s = new Solutionb198();
		int[] x = {1, 3, 4, 2, 15, 6, 8, 10};
		System.out.println(s.rob(x));
	}
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		int[][] f = new int[nums.length][2];
		f[0][0] = 0;
		f[0][1] = nums[0];
		for (int i = 1; i < nums.length; i ++){
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
			f[i][1] = f[i - 1][0] + nums[i];
		}
		return Math.max(f[nums.length - 1][0], f[nums.length - 1][1]);
	}
}