package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
	
	public static void main(String args[]){
		Solution51 s = new Solution51();
		List<List<String>> x = s.solveNQueens(4);
		for (List<String> i : x){
			for (String j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		int[] now = new int[21];
		boolean[][] b = new boolean[3][50];
		dfs(0, n, result, b, now);
		return result;
	}
	private void dfs(int i, int n, List<List<String>> result, boolean[][] b, int[] now) {
		if (i >= n){
			List<String> x = new ArrayList<String>();
			for (int j = 0; j < n; j ++){
				String st = "";
				for (int l = 0; l < now[j]; l ++) st += ".";st += "Q";
				for (int l = now[j] + 1; l < n; l ++) st += ".";
				x.add(st);
			}
			result.add(x);
			return;
		}
		for (int j = 0; j < n; j ++)
			if (!b[0][j] && !b[1][i + j] && !b[2][i + n - j]){
				b[0][j] = true;
				b[1][i + j] = true;
				b[2][i + n - j] = true;
				now[i] = j;
				dfs(i + 1, n, result, b, now);
				b[0][j] = false;
				b[1][i + j] = false;
				b[2][i + n - j] = false;
			}
	}
}