package leetcode;

public class Solution37 {
	
	public static void main(String args[]){
	}
	public void solveSudoku(char[][] board) {
		boolean[][][] b = new boolean[3][9][10];
		for (int i = 0; i < 9; i ++)
			for (int j = 0; j < 9; j ++)
				if (board[i][j] != '.'){
					int n = Integer.parseInt(board[i][j] + "");
					b[0][i][n] = true;
					b[1][j][n] = true;
					b[2][(i / 3) * 3 + j / 3][n] = true;
				}
		dfs(board, b, 0, 0);
	}
	private boolean dfs(char[][] board, boolean[][][] b, int i, int j) {
		if (i == 9) return true;
		if (board[i][j] != '.')
			return dfs(board, b, i + j / 8, (j + 1) % 9);
		int k = (i / 3) * 3 + j / 3;
		for (int l = 1; l < 10; l ++)
			if (!b[0][i][l] && !b[1][j][l] && !b[2][k][l]){
				b[0][i][l] = true;
				b[1][j][l] = true;
				b[2][k][l] = true;
				board[i][j] = (char)(l + 48);
				if (dfs(board, b, i + j / 8, (j + 1) % 9)) return true;
				b[0][i][l] = false;
				b[1][j][l] = false;
				b[2][k][l] = false;
				board[i][j] = '.';
			}
		return false;
	}
}