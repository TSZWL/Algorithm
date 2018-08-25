package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution18 {
	public static void main(String args[]){
		Solution18 s = new Solution18();
		String a = "23";
		List<String> r = s.letterCombinations(a);
		for (String st : r) System.out.println(st);
	}
	List<String> result = new ArrayList<String>();
	String [][] f = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, 
			{"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, 
			{"w", "x", "y", "z"}};
	public List<String> letterCombinations(String digits) {
		dfs(digits, 0, "");
		return result;
	}
	private void dfs(String digits, int i, String st) {
		if (i == digits.length()){
			if (!st.equals("")) result.add(st);
			return;
		}
		if ((digits.charAt(i) > '9') || (digits.charAt(i) < '2')) dfs(digits, i + 1, st);
		int x = Integer.parseInt(digits.substring(i, i + 1));
		for (int j = 0; j < f[x].length; j ++) dfs(digits, i + 1, st + f[x][j]);
	}
}