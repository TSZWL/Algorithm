package leetcode;

public class Solutionb130 {
	public static void main(String args[]){
	}
	//for循环向4个方向走 展开来写可以减少判断边界的次数
	private int[] xx = {0, 0, 1, -1};
	private int[] yy = {1, -1, 0, 0};
	public void solve(char[][] board) {
		int m = board.length;
		if (m == 0) return;
		int n = board[0].length;
		boolean[][] b = new boolean[m][n];
		for (int i = 0; i < m; i ++){
			if (board[i][0] == 'O' && !b[i][0]) dfs(board, b, i, 0, m, n);
			if (board[i][n - 1] == 'O' && !b[i][n - 1]) dfs(board, b, i, n - 1, m, n);
		}
		for (int i = 0; i < n; i ++){
			if (board[0][i] == 'O' && !b[0][i]) dfs(board, b, 0, i, m, n);
			if (board[m - 1][i] == 'O' && !b[m - 1][i]) dfs(board, b, m - 1, i, m, n);
		}
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (board[i][j] == 'O' && !b[i][j]) board[i][j] = 'X'; 
	}
	private void dfs(char[][] board, boolean[][] b, int x, int y, int m, int n) {
		b[x][y] = true;
		for (int i = 0; i < 4; i ++){
			int x1 = x + xx[i];
			int y1 = y + yy[i];
			if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && board[x1][y1] == 'O' && !b[x1][y1])
				dfs(board, b, x1, y1, m, n);
		}
	}
}