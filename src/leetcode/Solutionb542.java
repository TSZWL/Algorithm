package leetcode;

public class Solutionb542 {
	
	public static void main(String args[]){
	}
	//In the first sweep, we visit each entry in natural order and answer[i][j] = min(Integer.MAX_VALUE, min(answer[i - 1][j], answer[i][j - 1]) + 1)
	//In the second sweep, we visit each entry in reverse order and answer[i][j] = min(answer[i][j], min(answer[i + 1][j], answer[i][j + 1]) + 1)
	//同样是可行的
	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) return matrix;
		int n = matrix[0].length;
		int[] x = new int[m * n + 1];
		int[] y = new int[m * n + 1];
		int head = 0, tail = 0;
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (matrix[i][j] == 0) {
					x[tail] = i;
					y[tail ++] = j;
				} else matrix[i][j] = -1;
		int[] xx = {0, 0, 1, -1};
		int[] yy = {1, -1, 0, 0};
		while (head < tail) {
			int x1 = x[head], y1 = y[head ++];
			for (int i = 0; i < 4; i ++) {
				int x2 = x1 + xx[i], y2 = y1 + yy[i];
				if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && matrix[x2][y2] == -1) {
					matrix[x2][y2] = matrix[x1][y1] + 1;
					x[tail] = x2;
					y[tail ++] = y2;
				}
			}
		}
		return matrix;
	}
}