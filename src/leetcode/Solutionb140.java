package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Solutionb140 {
	
	public static void main(String args[]){
		Solutionb140 s = new Solutionb140();
		List<String> a = new ArrayList<String>();
		a.add("cat");
		a.add("cats");
		a.add("and");
		a.add("sand");
		a.add("dog");
		List<String> r = s.wordBreak("catsanddog", a);
		for (String st : r) System.out.println(st);
	}
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, Boolean> m = new HashMap<String, Boolean>();
		for (String st : wordDict) m.put(st, true);
		boolean[] d = new boolean[s.length() + 1];
		Stack<String> now = new Stack<String>();
		List<String> result = new ArrayList<String>();
		dfs(s, 0, m, now, result, d);
		return result;
	}
	private boolean dfs(String s, int l, Map<String, Boolean> m,
			Stack<String> now, List<String> result, boolean[] d) {
		if (l == s.length()){
			String r = "";
			for (String st : now) r += " " + st;
			result.add(r.substring(1));
			return false;
		}
		boolean b = true;
		for (int i = l + 1; i <= s.length(); i ++){
			if (!d[i] && m.containsKey(s.subSequence(l, i))){
				now.push(s.substring(l, i));
				b = dfs(s, i, m, now, result, d) && b;
				now.pop();
			}
		}
		d[l] = b;
		return d[l];
	}
}