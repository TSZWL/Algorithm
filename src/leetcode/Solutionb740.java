package leetcode;

public class Solutionb740 {
	
	public static void main(String args[]){
		Solutionb740 s = new Solutionb740();
		int[] a = {2, 2, 3, 3, 3, 4};
		System.out.println(s.deleteAndEarn(a));
	}
	public int deleteAndEarn(int[] nums) {
		int[] f = new int[10001];
		int[][] r = new int[10001][2];
		for (int i = 0; i < nums.length; i ++) f[nums[i]] += nums[i];
		for (int i = 1; i <= 10000; i ++){
			r[i][0] = Math.max(r[i - 1][0], r[i - 1][1]);
			r[i][1] = r[i - 1][0] + f[i];
		}
		return Math.max(r[10000][0], r[10000][1]);
	}
}