package leetcode;

public class Solutionb329 {
	public static void main(String args[]){
		Solutionb329 s = new Solutionb329();
		int[][] a = {{3,4,5}, {3,2,6}, {2,2,1}};
		System.out.println(s.longestIncreasingPath(a));
	}
	//拓扑排序ordfs
	//不应该用记录一共有几个比它小的  然后当为0之后再搜索这个点的方法
	//这样常数比较大而且慢  应该直接搜索  搜完之后记录当前点往下的长度  下次直接读取cache更易读简便快速
	int[] x = {0, 0, 1, -1};
	int[] y = {1, -1, 0, 0};
	public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) return 0;
		int n = matrix[0].length;
		int[][] f = new int[m][n];
		int[][] g = new int[m][n];
		boolean[][] b = new boolean[m][n];
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				for (int l = 0; l < 4; l ++){
					int xx = i + x[l], yy = j + y[l];
					if (xx >= 0 && yy >= 0 && xx < m && yy < n && matrix[xx][yy] < matrix[i][j]) g[i][j] ++;
				}
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (!b[i][j] && g[i][j] == 0){
					f[i][j] = 1;
					dfs(matrix, g, f, b, i, j, m, n);
				}
		int result = 1;
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				result = Math.max(result, f[i][j]);
		return result;
	}
	private void dfs(int[][] matrix, int[][] g, int[][] f, boolean[][] b, int i, int j, int m, int n) {
		b[i][j] = true;
		for (int l = 0; l < 4; l ++){
			int xx = i + x[l], yy = j + y[l];
			if (xx >= 0 && yy >= 0 && xx < m && yy < n && matrix[xx][yy] > matrix[i][j]){
				g[xx][yy] --;
				f[xx][yy] = Math.max(f[xx][yy], f[i][j] + 1);
				if (g[xx][yy] == 0) dfs(matrix, g, f, b, xx, yy, m, n);
			}
		}
	}
}