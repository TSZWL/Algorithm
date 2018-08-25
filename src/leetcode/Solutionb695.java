package leetcode;

public class Solutionb695 {
	
	public static void main(String args[]){
	}
	int[] a = {0, 0, 1, -1};
	int[] b = {1, -1, 0, 0};
	public int maxAreaOfIsland(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i ++)
			for (int j = 0; j < grid[0].length; j ++)
				if (grid[i][j] == 1){
					result = Math.max(result, dfs(grid, i, j));
				}
		return result;
	}
	private int dfs(int[][] f, int x, int y) {
		int result = 1;
		f[x][y] = 0;
		for (int i = 0; i < 4; i ++){
			int xx = x + a[i];
			int yy = y + b[i];
			if (xx >= 0 && xx < f.length && yy >= 0 && yy < f[0].length && f[xx][yy] == 1)
				result += dfs(f, xx, yy);
		}
		return result;
	}
}