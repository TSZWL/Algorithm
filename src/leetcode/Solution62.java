package leetcode;

public class Solution62 {
	
	public static void main(String args[]){
		Solution62 s = new Solution62();
		System.out.println(s.uniquePaths(100, 100));
	}
	public int uniquePaths(int m, int n) {
		int[][] f = new int[m][n];
		if (m == 0 || n == 0) return 0;
		for (int i = 0; i < m; i ++) f[i][0] = 1;
		for (int i = 0; i < n; i ++) f[0][i] = 1;
		for (int i = 1; i < m; i ++)
			for (int j = 1; j < n; j ++)
				f[i][j] = f[i - 1][j] + f[i][j - 1];
		return f[m - 1][n - 1];
	}
}