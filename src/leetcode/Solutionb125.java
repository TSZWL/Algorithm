package leetcode;

public class Solutionb125 {
	
	public static void main(String args[]){
		Solutionb125 s = new Solutionb125();
		System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
	}
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		char[] c = s.toCharArray();
		int i = 0, j = c.length - 1;
		while (i < j){
			while (i < c.length && (c[i] < 'a' || c[i] > 'z') && (c[i] < '0' || c[i] > '9')) i ++;
			while (j >= 0 && (c[j] < 'a' || c[j] > 'z') && (c[j] < '0' || c[j] > '9')) j --;
			if (i >= j) return true;
			if (c[i] != c[j]) return false;
			i ++;j --;
		}
		return true;
	}
}