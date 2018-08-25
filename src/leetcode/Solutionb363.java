package leetcode;

import java.util.*;

public class Solutionb363 {
	public static void main(String args[]){
		Solutionb363 s = new Solutionb363();
		int[][] a = {{1,0,1},{0,-2,3}};
		System.out.println(s.maxSumSubmatrix(a, 2));
	}
	//Treeset ceiling/floor/higher/lower
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		int result = Integer.MIN_VALUE;
		int[][] f = new int[Math.min(m, n)][Math.max(m, n)];
		if (m > n) {
			int x = m;
			m = n;
			n = x;
			for (int i = 0; i < m; i ++)
				for (int j = 0; j < n; j ++) f[i][j] = matrix[j][i];
		} else f = matrix;
		int[][] g = new int[m + 1][n];
		for (int i = 1; i <= m; i ++)
			for (int j = 0; j < n; j ++) g[i][j] = g[i - 1][j] + f[i - 1][j];
		for (int i = 0; i < m; i ++)
			for (int j = i + 1; j <= m; j ++) {
				int total = 0;
				TreeSet<Integer> set = new TreeSet<>();
				set.add(total);
				for (int l = 0; l < n; l ++) {
					total += g[j][l] - g[i][l];
					Integer x = set.ceiling(total - k);
					if (x != null) result = Math.max(total - x, result);
					set.add(total);
				}
			}
		return result;
	}
/*
int res = Integer.MIN_VALUE;
for (int i = 0; i < matrix[0].length; i++) {
	int[] sums = new int[matrix.length];
	for (int j = i; j < matrix[0].length; j++) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int m = 0; m < matrix.length; m++) {
			sums[m] += matrix[m][j];
//记录每一对(i,j)之间长条中矩形的最大值，以便剪枝
			sum = Math.max(sum + sums[m], sums[m]);
			max = Math.max(max, sum);
		}
		
		if (max <= k) {
			res = Math.max(res, max);
			continue;
		}
                
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		sum = 0;
		for (int s: sums) {
	 		sum += s;
			Integer prev = set.ceiling(sum - k);
			if (prev != null) {
				res = Math.max(res, sum - prev);
			}
				set.add(sum);
			}               
		}
	}
}
*/
}