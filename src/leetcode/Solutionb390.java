package leetcode;

public class Solutionb390 {
	
	public static void main(String args[]){
		Solutionb390 s = new Solutionb390();
		System.out.println(s.lastRemaining(9));
	}
	public int lastRemaining(int n) {
		return get(n, 1);
	}
	private int get(int n, int k) {
		if (n == 1) return 1;
		int x = get(n / 2, 1 - k);
		if (k == 0 && n % 2 == 0) return x * 2 - 1; else return x * 2;
	}
}
//Ã»´ó¿´¶®
//return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));