package leetcode;

public class Solution48 {
	
	public static void main(String args[]){
	}
	public void rotate(int[][] matrix) {
		int l = matrix.length;
		for (int i = 0; i < l / 2; i ++)
			for (int j = 0; j < (l + 1) / 2; j ++){
				int last = matrix[i][j];
				matrix[i][j] = matrix[l - j - 1][i];
				matrix[l - j - 1][i] = matrix[l - i - 1][l - j - 1];
				matrix[l - i - 1][l - j - 1] = matrix[j][l - i - 1];
				matrix[j][l - i - 1] = last;
			}
	}
}