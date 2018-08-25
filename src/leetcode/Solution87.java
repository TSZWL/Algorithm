package leetcode;

public class Solution87 {
	public static void main(String args[]){
		Solution87 s = new Solution87();
		System.out.println(s.isScramble("great", "rtgea"));
	}
	public boolean isScramble(String s1, String s2) {
		int[] a = new int[26], b = new int[26];
		for (int i = 0; i < s1.length(); i ++){
			a[s1.charAt(i) - 'a'] ++;
			b[s2.charAt(i) - 'a'] ++;
		}
		for (int i = 0; i < 26; i ++)
			if (a[i] != b[i]) return false;
		if (s1.length() < 4) return true;
		for (int i = 1; i < s1.length(); i ++){
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i))) return true;
			if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
					&& isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) return true;
		}
		return false;
	}
}