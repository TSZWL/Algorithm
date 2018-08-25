package leetcode;

public class Solution79 {
	
	public static void main(String args[]){
	}
	int[] x = {0, 0, 1, -1};
	int[] y = {-1, 1, 0, 0};
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0) return true;
		int m = board.length;
		if (m == 0) return false;
		int n = board[0].length;
		boolean[][] b = new boolean[m][n];
		char[] c = word.toCharArray();
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (c[0] == board[i][j]){
					b[i][j] = true;
					if (dfs(board, b, c, i, j, 1, m, n)) return true;
					b[i][j] = false;
				}
		return false;
	}
	private boolean dfs(char[][] a, boolean[][] b, char[] c, int i, int j, int now, int m, int n) {
		if (c.length == now) return true;
		for (int l = 0; l < 4; l ++){
			int xx = i + x[l], yy = j + y[l];
			if (xx < 0 || yy < 0 || xx == m || yy == n || 
					a[xx][yy] != c[now] || b[xx][yy]) continue;
			b[xx][yy] = true;
			if (dfs(a, b, c, xx, yy, now + 1, m, n)) return true;
			b[xx][yy] = false;
		}
		return false;
	}
}