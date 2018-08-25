package leetcode;

public class Solutionb647 {
	
	public static void main(String args[]){
		Solutionb647 s = new Solutionb647();
		System.out.println(s.countSubstrings("aaa"));
	}
	private int result = 1;
	public int countSubstrings(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length - 1; i ++){
			add(c, i, i + 1);
			add(c, i, i);
		}
		return result;
	}
	private void add(char[] c, int i, int j) {
		while (i >= 0 && j < c.length && c[i] == c[j]){
			i --;
			j ++;
			result ++;
		}
	}
}