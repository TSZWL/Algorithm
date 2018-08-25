package leetcode;

public class Solution63 {
	
	public static void main(String args[]){
		Solution63 s = new Solution63();
		int[][] a = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(s.uniquePathsWithObstacles(a));
	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0) return 0;
		int n = obstacleGrid[0].length;
		int[][] f = new int[m][n];
		f[0][0] = 1 - obstacleGrid[0][0];
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (obstacleGrid[i][j] == 0){
					if (i > 0 && obstacleGrid[i - 1][j] == 0) f[i][j] += f[i - 1][j];
					if (j > 0 && obstacleGrid[i][j - 1] == 0) f[i][j] += f[i][j - 1];
				}
		return f[m - 1][n - 1];
	}
}