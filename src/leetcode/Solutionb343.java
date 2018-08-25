package leetcode;

public class Solutionb343 {
	
	public static void main(String args[]){
		Solutionb343 s = new Solutionb343();
		System.out.println(s.integerBreak(2));
	}
	public int integerBreak(int n) {
		int[] f = new int[n + 1];
		for (int i = 2; i <= n; i ++){
			if (f[i - 1] < i - 1) f[i - 1] = i - 1;
			for (int j = 1; j < i; j ++)
				f[i] = Math.max(f[i], f[j] * (i - j));
		}
		return f[n];
	}
}