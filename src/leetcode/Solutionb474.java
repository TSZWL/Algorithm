package leetcode;

public class Solutionb474 {
	public static void main(String args[]){
	}
	public int findMaxForm(String[] strs, int m, int n) {
		int x = strs.length;
		int[][] num = new int[x][2];
		int[][] f = new int[m + 1][n + 1];
		for (int i = 0; i < x; i ++)
			for (char c : strs[i].toCharArray()) num[i][c - '0'] ++;
		for (int i = 0; i < x; i ++)
			for (int j = m; j >= num[i][0]; j --)
				for (int l = n; l >= num[i][1]; l --)
					f[j][l] = Math.max(f[j][l], f[j - num[i][0]][l - num[i][1]] + 1);
		return f[m][n];
	}
}