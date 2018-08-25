package leetcode;

import java.util.Arrays;

public class Solutionb242 {
	
	public static void main(String args[]){
		Solutionb242 s = new Solutionb242();
		System.out.println(s.isAnagram("anagram", "nagaram"));
	}
	public boolean isAnagram(String s, String t) {
		char[] c1 = s.toCharArray();
		Arrays.sort(c1);
		String st = new String(c1);
		char[] c2 = t.toCharArray();
		Arrays.sort(c2);
		String ts = new String(c2);
		if (st.equals(ts)) return true;
		return false;
	}
}