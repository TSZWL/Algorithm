package leetcode;

public class Solutionb205 {
	
	public static void main(String args[]){
		Solutionb205 s = new Solutionb205();
		System.out.println(s.isIsomorphic("ab", "aa"));
	}
	public boolean isIsomorphic(String s, String t) {
		char[] f = new char[200];
		boolean[] d = new boolean[200];
		boolean[] e = new boolean[200];
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		if (a.length != b.length) return false;
		for (int i = 0; i < a.length; i ++)
			if (!d[a[i]]){
				if (e[b[i]]) return false;
				f[a[i]] = b[i];
				d[a[i]] = true;
				e[b[i]] = true;
			} else if (f[a[i]] != b[i]) return false;
		return true;
	}
}