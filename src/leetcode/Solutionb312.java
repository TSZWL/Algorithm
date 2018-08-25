package leetcode;

public class Solutionb312 {
	public static void main(String args[]){
		Solutionb312 s = new Solutionb312(); 
		int[] a = {3, 1, 5, 8};
		System.out.println(s.maxCoins(a));
	}
	public int maxCoins(int[] nums) {
		int l = nums.length + 2;
		int[] f = new int[l];
		int[][] g = new int[l][l];
		for (int i = 0; i < l; i ++){
			if (i == 0 || i == l - 1) f[i] = 1;
			else f[i] = nums[i - 1];
		}
		for (int i = 1; i < l - 1; i ++)
			g[1][i] = f[i - 1] * f[i] * f[i + 1];
		for (int k = 2; k < l - 1; k ++)
			for (int i = 1; i < l - k; i ++)
				for (int j = 0; j < k; j ++)
					g[k][i] = Math.max(g[k][i], g[j][i] + g[k - j - 1][i + j + 1] + f[i + j] * f[i - 1] * f[i + k]);
		return g[l - 2][1];
	}
}
/*
 * 枚举最后一个删除的气球的位置
 * 为什么递归比循环快？效率应该相同的
 * for (int i = left+1; i <= right - 1; i++) {
 *     int sum = nums[left] * nums[i] * nums[right];
 *     sum += getMax(nums, left, i, cache) + getMax(nums, i, right, cache);
 *     max = Math.max(max, sum);
 * }
 */