package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb438 {
	
	public static void main(String args[]){
		Solutionb438 s = new Solutionb438();
		List<Integer> l = s.findAnagrams("abab", "ab");
		for (int i : l) System.out.println(i);
	}
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if (s.length() < p.length()) return result;
		int[] c = new int[26];
		for (int i = 0; i < p.length(); i ++) c[p.charAt(i) - 'a'] ++;
		int d = 0;
		for (int i = 0; i < p.length(); i ++){
			int a = s.charAt(i) - 'a';
			c[a] --;
			if (c[a] < 0) d ++;
		}
		if (d == 0) result.add(0);
		for (int i = p.length(); i < s.length(); i ++){
			int a = s.charAt(i) - 'a';
			int b = s.charAt(i - p.length()) - 'a';
			c[b] ++;
			if (c[b] <= 0) d --;
			c[a] --;
			if (c[a] < 0) d ++;
			if (d == 0) result.add(i - p.length() + 1);
		}
		return result;
	}
}