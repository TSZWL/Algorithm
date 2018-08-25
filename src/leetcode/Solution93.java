package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
	
	public static void main(String args[]){
		Solution93 s = new Solution93();
		List<String> r = s.restoreIpAddresses("010010");
		for (String c : r) System.out.println(c);
	}
	List<String> result = new ArrayList<String>();
	String now = "";
	public List<String> restoreIpAddresses(String s) {
		dfs(0, 0, s);
		return result;
	}
	private void dfs(int n, int j, String s){
		if ((s.length() - j - 1) / 3 > 3 - n) return;
		if (s.length() - j < 4 - n) return;
		if (n == 3){
			String st = s.substring(j);
			if (Integer.parseInt(st) > 255) return;
			if (st.length() > 1 && st.startsWith("0")) return;
			now += st;
			result.add(now);
			now = now.substring(0, now.lastIndexOf(st));
		}
		for (int i = 1; i < 4; i ++){
			if (i + j >= s.length()) return;
			String st = s.substring(j, j + i);
			if (Integer.parseInt(st) > 255) break;
			if (st.length() > 1 && st.startsWith("0")) continue;
			now += st + ".";
			dfs(n + 1, j + i, s);
			now = now.substring(0, now.lastIndexOf(st));
		}
	}
}