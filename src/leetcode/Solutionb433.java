package leetcode;

import java.util.*;

public class Solutionb433 {
	
	public static void main(String args[]){
		Solutionb433 s = new Solutionb433();
		String[] a = {"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"};
		System.out.println(s.minMutation("AAAAAAAA", "CCCCCCCC", a));
	}
	//数据量很小 单向bfs即可(b126
	public int minMutation(String start, String end, String[] bank) {
		if (start.equals(end)) return 0;
		Set<String> dict = new HashSet<String>();
		for (String s : bank) dict.add(s);
		if (!dict.contains(end)) return -1;
		dict.add(start);
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		set1.add(start);
		set2.add(end);
		return dfs(dict, set1, set2, 1);
	}
	private int dfs(Set<String> dict, Set<String> set1, Set<String> set2, int r) {
		char[] t = {'A', 'T', 'G', 'C'};
		dict.removeAll(set1);
		if (set1.isEmpty()) return -1;
		Set<String> set3 = new HashSet<String>();
		for (Iterator<String> it = set1.iterator(); it.hasNext(); ) {
			String now = it.next();
			for (int i = 0; i < now.length(); i ++) {
				char[] x = now.toCharArray();
				for (int j = 0; j < 4; j ++) {
					x[i] = t[j];
					String next = new String(x);
					if (dict.contains(next)) {
						if (set2.contains(next)) return r;
						set3.add(next);
					}
				}
			}
		}
		return dfs(dict, set2, set3, r + 1);
	}
}