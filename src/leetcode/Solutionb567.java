package leetcode;

public class Solutionb567 {
	
	public static void main(String args[]){
		Solutionb567 s = new Solutionb567();
		System.out.println(s.checkInclusion("ab", "eidboaoo"));
	}
	public boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length()) return false;
		int[] c = new int[256];
		for (int i = 0; i < s1.length(); i ++) c[s1.charAt(i)] ++;
		int d = 0;
		for (int i = 0; i < s1.length(); i ++){
			int a = s2.charAt(i);
			c[a] --;
			if (c[a] < 0) d ++;
		}
		if (d == 0) return true;
		for (int i = s1.length(); i < s2.length(); i ++){
			int a = s2.charAt(i);
			int b = s2.charAt(i - s1.length());
			c[b] ++;
			if (c[b] <= 0) d --;
			c[a] --;
			if (c[a] < 0) d ++;
			if (d == 0) return true;
		}
		return false;
	}
}