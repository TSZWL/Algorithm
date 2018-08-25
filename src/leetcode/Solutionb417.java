package leetcode;

import java.util.*;

public class Solutionb417 {
	
	public static void main(String args[]){
	}
	//写深搜方便一点
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<int[]>();
		int m = matrix.length;
		if (m == 0) return result;
		int n = matrix[0].length;
		int[][] f = new int[m][n];
		int[] x = new int[m * n + 1];
		int[] y = new int[m * n + 1];
		int head = 0, tail = 0;
		for (int i = 0; i < m; i ++) {
			x[tail] = i;
			y[tail ++] = 0;
			f[i][0] += 1;
		}
		for (int j = 1; j < n; j ++) {
			x[tail] = 0;
			y[tail ++] = j;
			f[0][j] += 1;
		}
		int[] xx = {0, 0, 1, -1};
		int[] yy = {1, -1, 0, 0};
		while (head < tail) {
			int x1 = x[head], y1 = y[head ++];
			for (int i = 0; i < 4; i ++) {
				int x2 = x1 + xx[i], y2 = y1 + yy[i];
				if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && 
						(f[x2][y2] & 1) == 0 && matrix[x2][y2] >= matrix[x1][y1]) {
					f[x2][y2] += 1;
					x[tail] = x2;
					y[tail ++] = y2;
				}
			}
		}
		//
		head = 0;
		tail = 0;
		for (int i = 0; i < m; i ++) {
			x[tail] = i;
			y[tail ++] = n - 1;
			f[i][n - 1] += 2;
		}
		for (int j = 0; j < n - 1; j ++) {
			x[tail] = m - 1;
			y[tail ++] = j;
			f[m - 1][j] += 2;
		}
		while (head < tail) {
			int x1 = x[head], y1 = y[head ++];
			if (f[x1][y1] == 3) result.add(new int[]{x1, y1});
			for (int i = 0; i < 4; i ++) {
				int x2 = x1 + xx[i], y2 = y1 + yy[i];
				if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && 
						(f[x2][y2] & 2) == 0 && matrix[x2][y2] >= matrix[x1][y1]) {
					f[x2][y2] += 2;
					x[tail] = x2;
					y[tail ++] = y2;
				}
			}
		}
		return result;
	}
}