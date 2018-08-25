package leetcode;

public class Solutionb661 {
	
	public static void main(String args[]){
	}
	public int[][] imageSmoother(int[][] M) {
		int m = M.length;
		if (m == 0) return M;
		int n = M[0].length;
		int[][] f = new int[m][n];
		int[] x = {1, 1, 1, 0, 0, 0, -1, -1, -1};
		int[] y = {1, 0, -1, 1, 0, -1, 1, 0, -1};
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++){
				int q = 0, p = 0;
				for (int l = 0; l < 9; l ++){
					int xx = i + x[l];
					int yy = j + y[l];
					if (xx >= 0 && yy >= 0 && xx < m && yy < n){
						q += M[xx][yy];
						p ++;
					}
				}
				f[i][j] = (int)Math.floor((q + 0.0) / p);
			}
		return f;
	}
}