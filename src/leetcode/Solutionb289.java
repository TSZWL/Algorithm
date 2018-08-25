package leetcode;

public class Solutionb289 {
	
	public static void main(String args[]){
	}
	public void gameOfLife(int[][] board) {
		int m = board.length;
		if (m == 0) return;
		int n = board[0].length;
		int[][] now = new int[m][n];
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++){
				int l = check(board, i, j, m, n);
				if (board[i][j] == 0){
					if (l == 3) now[i][j] = 1;
				} else {
					if (l > 1 && l < 4) now[i][j] = 1;
				}
			}
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++) board[i][j] = now[i][j];
	}
	private int check(int[][] board, int i, int j, int m, int n) {
		int[] x = {0, 0, 1, 1, 1, -1, -1, -1};
		int[] y = {1, -1, 1, 0, -1, 1, 0, -1};
		int result = 0;
		for (int l = 0; l < 8; l ++){
			int a = i + x[l], b = j + y[l];
			if (a < 0 || a == m) continue;
			if (b < 0 || b == n) continue;
			result += board[a][b];
		}
		return result;
	}
}