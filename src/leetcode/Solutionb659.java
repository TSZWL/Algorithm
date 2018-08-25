package leetcode;

public class Solutionb659 {
	
	public static void main(String args[]){
		Solutionb659 s = new Solutionb659();
		int[] a = {1,2,3,4,4,5};
		System.out.println(s.isPossible(a));
	}
	public boolean isPossible(int[] nums) {
		if (nums.length == 0) return true;
		int[][] f = new int[nums.length + 1][2];
		f[0][0] = 1;
		f[0][1] = nums[0];
		int l = 1;
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] == nums[i - 1]) f[l - 1][0] ++;
			else {
				f[l][0] = 1;
				f[l ++][1] = nums[i];
			}
		int[] g = new int[3];
		g[0] = f[0][0];
		for (int i = 1; i <= l; i ++)
			if (f[i][1] == f[i - 1][1] + 1) {
				if (f[i][0] < g[0] + g[1]) return false;
				g[2] = Math.min(f[i][0] - g[0], g[1] + g[2]);
				g[1] = g[0];
				g[0] = f[i][0] - g[1] - g[2];
			} else {
				if (g[0] != 0 || g[1] != 0) return false;
				g[2] = 0;
				g[0] = f[i][0];
			}
		return true;
	}
}