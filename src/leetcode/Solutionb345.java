package leetcode;

public class Solutionb345 {
	
	public static void main(String args[]){
		Solutionb345 s = new Solutionb345();
		System.out.println(s.reverseVowels("abcdefghijk"));
	}
	public String reverseVowels(String s) {
		char[] c = s.toCharArray();
		int l = 0, r = c.length - 1;
		while (true){
			while (l < c.length && !check(c[l])) l ++;
			while (r > 0 && !check(c[r])) r --;
			if (l >= r) return new String(c);
			char h = c[l];
			c[l] = c[r];
			c[r] = h;
			l ++;
			r --;
		}
	}
	private boolean check(char x){
		if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') return true;
		if (x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U') return true;
		return false;
	}
}