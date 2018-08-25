package leetcode;

class NumMatrix {

	private int[][] line, sum;
	public NumMatrix(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) return;
		int n = matrix[0].length;
		line = new int[m][n];
		sum = new int[m][n];
		for (int i = 0; i < m; i ++){
			line[i][0] = matrix[i][0];
			for (int j = 1; j < n; j ++) line[i][j] = line[i][j - 1] + matrix[i][j];
		}
		for (int i = 0; i < n; i ++){
			sum[0][i] = line[0][i];
			for (int j = 1; j < m; j ++) sum[j][i] = sum[j - 1][i] + line[j][i];
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		int result = sum[row2][col2];
		if (row1 > 0 && col1 > 0) result += sum[row1 - 1][col1 - 1];
		if (row1 > 0) result -= sum[row1 - 1][col2];
		if (col1 > 0) result -= sum[row2][col1 - 1];
		return result;
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */