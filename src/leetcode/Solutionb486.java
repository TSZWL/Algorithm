package leetcode;

public class Solutionb486 {
	
	public static void main(String args[]){
		Solutionb486 s = new Solutionb486();
		int[] a = {1, 5, 233, 7};
		System.out.println(s.PredictTheWinner(a));
	}
	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		for (int i = 0; i < n; i ++) f[i] = nums[i];
		for (int i = 1; i < n; i ++)
			for (int j = 0; j < n - i; j ++)
				f[j] = Math.max(nums[j] - f[j + 1], nums[j + i] - f[j]);
		return f[0] >= 0;
	}
}