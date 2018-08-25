package leetcode;

public class Solution36 {
	
	public static void main(String args[]){
	}
	public boolean isValidSudoku(char[][] board){
		boolean[][][] b = new boolean[3][9][10];
		for (int i = 0; i < 9; i ++)
			for (int j = 0; j < 9; j ++)
				if (board[i][j] != '.'){
					int n = Integer.parseInt(board[i][j] + "");
					if (b[0][i][n] || b[1][j][n] || b[2][(i / 3) * 3 + j / 3][n]) return false;
					b[0][i][n] = true;
					b[1][j][n] = true;
					b[2][(i / 3) * 3 + j / 3][n] = true;
				}
		return true;
	}
}