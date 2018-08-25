package leetcode;

public class Solution52 {
	
	public static void main(String args[]){
		Solution52 s = new Solution52();
		System.out.println(s.totalNQueens(4));
	}
	public int totalNQueens(int n) {
		boolean[][] b = new boolean[3][50];
		return dfs(0, n, b);
	}
	private int dfs(int i, int n, boolean[][] b) {
		if (i >= n) return 1;
		int x = 0;
		for (int j = 0; j < n; j ++)
			if (!b[0][j] && !b[1][i + j] && !b[2][i + n - j]){
				b[0][j] = true;
				b[1][i + j] = true;
				b[2][i + n - j] = true;
				x += dfs(i + 1, n, b);
				b[0][j] = false;
				b[1][i + j] = false;
				b[2][i + n - j] = false;
			}
		return x;
	}
}