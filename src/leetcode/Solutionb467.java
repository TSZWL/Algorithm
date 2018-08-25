package leetcode;

public class Solutionb467 {
	
	public static void main(String args[]){
		Solutionb467 s = new Solutionb467();
		System.out.println(s.findSubstringInWraproundString("cac"));
	}
	public int findSubstringInWraproundString(String p) {
		if (p.length() == 0) return 0;
		int[] f = new int[26];
		char[] c = p.toCharArray();
		int result = 0, now = 1;
		f[c[0] - 'a'] = 1;
		for (int i = 1; i < c.length; i ++){
			if ((c[i - 1] - 'a' + 1) % 26 == c[i] - 'a') now ++; else now = 1;
			f[c[i] - 'a'] = Math.max(f[c[i] - 'a'], now);
		}
		for (int i = 0; i < 26; i ++) result += f[i];
		return result;
	}
}