package leetcode;

public class Solutionb392 {
	
	public static void main(String args[]){
	}
	public boolean isSubsequence(String s, String t) {
		char[] a = s.toCharArray();
		if (a.length == 0) return true;
		char[] b = t.toCharArray();
		for (int i = 0, tail = 0; i < b.length; i ++)
			if (b[i] == a[tail])
				if (++ tail == a.length) return true;
		return false;
	}
}