package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
	
	public static void main(String args[]){
		Solution54 s = new Solution54();
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		s.spiralOrder(a);
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		int[] x = {0, 1, 0, -1};
		int[] y = {1, 0, -1, 0};
		List<Integer> result = new ArrayList<Integer>();
		int n = matrix.length;
		if (n == 0) return result;
		int m = matrix[0].length, a = 0, b = 0, c = 0;
		boolean[][] d = new boolean[n][m];
		while (result.size() < n * m - 1){
			int aa = a + x[c], bb = b + y[c];
			if (aa < 0 || bb < 0 || aa == n || bb == m || d[aa][bb]){
				c = (c + 1) % 4;
				continue;
			}
			result.add(matrix[a][b]);
			d[a][b] = true;
			a = aa;
			b = bb;
		}
		result.add(matrix[a][b]);
		return result;
	}
}