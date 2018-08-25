package leetcode;

import java.util.*;

public class Solutionb290 {
	
	public static void main(String args[]){
		Solutionb290 s = new Solutionb290();
		System.out.println(s.wordPattern("abba", "dog dog dog dog"));
	}
	public boolean wordPattern(String pattern, String str) {
		String[] f = new String[200];
		boolean[] d = new boolean[200];
		Set<String> set = new HashSet<String>();
		char[] a = pattern.toCharArray();
		String[] b = str.split(" ");
		if (a.length != b.length) return false;
		for (int i = 0; i < a.length; i ++)
			if (!d[a[i]]){
				if (set.contains(b[i])) return false;
				f[a[i]] = b[i];
				d[a[i]] = true;
				set.add(b[i]);
			} else if (!f[a[i]].equals(b[i])) return false;
		return true;
	}
}