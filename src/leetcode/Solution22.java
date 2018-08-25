package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
	
	public static void main(String args[]){
		Solution22 s = new Solution22();
		s.generateParenthesis(3);
		for (String st : x){
			System.out.println(st);
		}
	}
	private static List<String> x = new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
		dfs(n, 0, "");
		return x;
	}
	private void dfs(int n, int y, String st) {
		if (n == 0){
			while (st.length() < y * 2) st += ")";
			x.add(st);
			return;
		}
		dfs(n - 1, y + 1, st + "(");
		if (st.length() < y * 2) dfs(n, y, st + ")");
	}
}