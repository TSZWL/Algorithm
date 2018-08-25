package leetcode;

public class Solution44 {
	public static void main(String args[]){
		Solution44 s = new Solution44();
		System.out.println(s.isMatch("aa", "*"));
		System.out.println(s.isMatch("aaa", "aa*aa"));
		System.out.println(s.isMatch("ababbaaaaabbabbbabbbaaa", "*aa*baa"));
		System.out.println(s.isMatch("c", "*?*"));
	}
	//匹配=>第一个字符串中是不会包含*和?的=>单串匹配,回溯
	public boolean isMatch(String s, String p) {
		s += ".";p += ".";
		int l1 = 0, l2 = 0;
		int lastl1 = 0, lastl2 = 0;
		while (l2 < p.length()){
			if (isEqual(s.charAt(l1), p.charAt(l2))){
				l1 ++;
				l2 ++;
			} else if (p.charAt(l2) == '*'){
				while (p.charAt(l2) == '*') l2 ++;
				char c22 = p.charAt(l2);
				while ((l1 < s.length() - 1) && (!isEqual(s.charAt(l1), c22))) l1 ++;
				if (isEqual(s.charAt(l1), c22)){
					lastl1 = l1 + 1;
					lastl2 = l2 - 1;
					l2 ++;
					l1 = lastl1;
				} else {
					if (lastl1 == 0) return false;
					l2 = lastl2;
					l1 = lastl1;
					lastl1 = 0;
					lastl2 = 0;
				}
			} else {
				if (lastl1 == 0) return false;
				l2 = lastl2;
				l1 = lastl1;
				lastl1 = 0;
				lastl2 = 0;
			}
		}
		return true;
	}
	private boolean isEqual(char a, char b) {
		if (a == b) return true;
		if (a == '.') return false;
		if (b == '?') return true;
		return false;
	}
}