package leetcode;

public class Solution73 {
	
	public static void main(String args[]){
	}
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) return;
		int n = matrix[0].length;
		boolean a = false, b = false;
		for (int i = 0; i < m; i ++)
			if (matrix[i][0] == 0) a = true;
		for (int i = 0; i < n; i ++)
			if (matrix[0][i] == 0) b = true;
		for (int i = 1; i < m; i ++)
			for (int j = 1; j < n; j ++)
				if (matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
		for (int i = 1; i < m; i ++)
			for (int j = 1; j < n; j ++)
				if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
		if (a) for (int i = 0; i < m; i ++) matrix[i][0] = 0;
		if (b) for (int i = 0; i < n; i ++) matrix[0][i] = 0;
	}
}