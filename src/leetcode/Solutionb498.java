package leetcode;

public class Solutionb498 {
	public static void main(String args[]){
	}
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return new int[0];
		int m = matrix.length, n = matrix[0].length;
		int[] result = new int[m * n];
		int row = 0, col = 0, d = 0;
		int[][] dirs = {{-1, 1}, {1, -1}};
		for (int i = 0; i < m * n; i++) {
			result[i] = matrix[row][col];
			row += dirs[d][0];
			col += dirs[d][1];
			if (row >= m){
				row = m - 1;
				col += 2;
				d = 1 - d;
			} else if (col >= n){
				col = n - 1;
				row += 2;
				d = 1 - d;
			} else if (row < 0){
				row = 0;
				d = 1 - d;
			} else if (col < 0){
				col = 0;
				d = 1 - d;
			}
		}
		return result;
	}
}