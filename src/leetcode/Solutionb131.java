package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb131 {
	
	public static void main(String args[]){
		Solutionb131 s = new Solutionb131();
		String a = "abbab";
		List<List<String>> r = s.partition(a);
		for (List<String> c : r){
			for (String b : c) System.out.print(b + " ");
			System.out.println();
		}
	}
	List<List<String>> result = new ArrayList<List<String>>();
	List<String> now = new ArrayList<String>();
	public List<List<String>> partition(String s) {
		int l = s.length();
		boolean[][] b = new boolean[l][l];
		for (int i = 0; i < l; i ++) b[i][i] = true;
		for (int i = 0; i < l - 1; i ++) b[i + 1][i] = true;
		for (int i = 1; i < l; i ++)
			for (int j = 0; j < l - i; j ++)
				if (s.charAt(j) == s.charAt(i + j)) b[j][i + j] = b[j + 1][i + j - 1];
		dfs(0, l, b, s);
		return result;
	}
	private void dfs(int n, int l, boolean[][] b, String s){
		if (n == l){
			List<String> list = new ArrayList<String>(now);
			result.add(list);
		}
		for (int i = n; i < l; i ++)
			if (b[n][i]){
				now.add(s.substring(n, i + 1));
				dfs(i + 1, l, b, s);
				now.remove(now.size() - 1);
			}
	}
}