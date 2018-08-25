package leetcode;

public class Solutionb410 {
	
	public static void main(String args[]){
		Solutionb410 s = new Solutionb410();
		int[] a = {7,2,5,10,8};
		System.out.println(s.splitArray(a, 2));
	}
	//多么经典的二分答案O(logn*n)，又没想到(问题的性质)
	//本来写的是F[i][j]=max(F[i-x][j-1],Sum[i-x~i])，在i-x上二分
	public int splitArray(int[] nums, int m) {
		int[][] f = new int[nums.length][m];
		int[] sum = new int[nums.length];
		f[0][0] = nums[0];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i ++) {
			sum[i] = sum[i - 1] + nums[i];
			for (int j = Math.max(0, m - nums.length + i); j < Math.min(m, i + 1); j ++)
				if (j == 0) {
					f[i][0] = sum[i];
				} else {
					int head = j - 1, tail = i - 1;
					while (head < tail - 1) {
						int mid = (head + tail) / 2;
						if (f[mid][j - 1] > sum[i] - sum[mid]) tail = mid; else head = mid;
					}
					f[i][j] = Math.min(Math.max(f[head][j - 1], sum[i] - sum[head])
							, Math.max(f[tail][j - 1], sum[i] - sum[tail]));
				}
		}
		return f[nums.length - 1][m - 1];
	}
}