package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Solutionb139 {
	
	public static void main(String args[]){
		Solutionb139 s = new Solutionb139();
		List<String> a = new ArrayList<String>();
		a.add("leet");
		a.add("code");
		System.out.println(s.wordBreak("leetcodes", a));
	}
	//直接DP就可以了。。O(len^2)
	public boolean wordBreak(String s, List<String> wordDict) {
		Map<String, Boolean> m = new HashMap<String, Boolean>();
		for (String st : wordDict) m.put(st, true);
		boolean[] d = new boolean[s.length() + 1];
		return dfs(s, 0, m, d);
	}
	private boolean dfs(String s, int l, Map<String, Boolean> m, boolean[] d) {
		if (l == s.length()) return true;
		for (int i = l + 1; i <= s.length(); i ++)
			if (!d[i] && m.containsKey(s.subSequence(l, i)))
				if (dfs(s, i, m, d)) return true;
		d[l] = true;
		return false;
	}
}