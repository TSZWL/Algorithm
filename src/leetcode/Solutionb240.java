package leetcode;

public class Solutionb240 {
	
	public static void main(String args[]){
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0) return false;
		int n = matrix[0].length;
		if (n == 0) return false;
		int a = m - 1, b = 0;
		while (a >= 0 && b < n)
			if (matrix[a][b] == target) return true;
			else if (matrix[a][b] > target) a --;
			else b ++;
		return false;
	}
}