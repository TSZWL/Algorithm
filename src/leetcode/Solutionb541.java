package leetcode;

public class Solutionb541 {
	
	public static void main(String args[]){
		Solutionb541 s = new Solutionb541();
		System.out.println(s.reverseStr("abcdefghijk", 4));
	}
	public String reverseStr(String s, int k) {
		char[] c = s.toCharArray();
		for (int i = 0; i <= (c.length - 1) / 2 / k; i ++)
			deal(c, i * 2 * k, Math.min(c.length - i * 2 * k, k));
		return new String(c);
	}
	private void deal(char[] c, int s, int l) {
		for (int i = 0; i < l / 2; i ++){
			char h = c[s + i];
			c[s + i] = c[s + l - i - 1];
			c[s + l - i - 1] = h;
		}
	}
}