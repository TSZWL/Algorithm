package leetcode;

public class Solutionb213 {
	
	public static void main(String args[]){
		Solutionb213 s = new Solutionb213();
		int[] x = {1, 3, 4, 2, 15, 6, 8, 10};
		System.out.println(s.rob(x));
	}
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int[][] f = new int[nums.length][2];
		f[1][0] = 0;
		f[1][1] = nums[1];
		for (int i = 2; i < nums.length; i ++){
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
			f[i][1] = f[i - 1][0] + nums[i];
		}
		int result = Math.max(f[nums.length - 1][0], f[nums.length - 1][1]);
		//the other
		f[0][0] = 0;
		f[0][1] = nums[0];
		for (int i = 1; i < nums.length - 1; i ++){
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
			f[i][1] = f[i - 1][0] + nums[i];
		}
		return Math.max(Math.max(f[nums.length - 2][0], f[nums.length - 2][1]), result);
	}
}