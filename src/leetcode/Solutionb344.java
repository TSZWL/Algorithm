package leetcode;

public class Solutionb344 {
	
	public static void main(String args[]){
		Solutionb344 s = new Solutionb344();
		System.out.println(s.reverseString("abcdefghijk"));
	}
	public String reverseString(String s) {
		char[] c = s.toCharArray();
		int l = c.length;
		for (int i = 0; i < l / 2; i ++){
			char h = c[i];
			c[i] = c[l - i - 1];
			c[l - i - 1] = h;
		}
		return new String(c);
	}
}