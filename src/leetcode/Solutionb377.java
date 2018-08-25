package leetcode;

public class Solutionb377 {
	
	public static void main(String args[]){
	}
	public int combinationSum4(int[] nums, int target) {
		int[] f = new int[target + 1];
		f[0] = 1;
		for (int i = 1; i <= target; i ++)
			for (int j = 0; j < nums.length; j ++)
				if (i >= nums[j]) f[i] += f[i - nums[j]];
		return f[target];
	}
}
/* 想得太多了
		int[][] f = new int[2][target + 1];
		int k = 0, ans = 0;
		f[0][0] = 1;
		boolean b = true;
		while (b) {
			b = false;
			ans += f[k][target];
			f[k][target] = 0;
			for (int i = 0; i < target; i ++)
				if (f[k][i] != 0) {
					b = true;
					for (int j = 0; j < nums.length; j ++)
						if (i + nums[j] <= target) f[1 - k][i + nums[j]] += f[k][i];
					f[k][i] = 0;
				}
			k = 1 - k;
		}
		return ans;
*/