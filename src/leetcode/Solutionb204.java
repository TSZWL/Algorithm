package leetcode;

public class Solutionb204 {
	
	public static void main(String args[]){
		Solutionb204 s = new Solutionb204();
		System.out.println(s.countPrimes(1000000));
	}
	public int countPrimes(int n) {
		int x = 0;
		int[] f = new int[n];
		boolean[] b = new boolean[n];
		for (int i = 2; i < n; i ++){
			if (!b[i]) f[x ++] = i;
			for (int j = 0; j < x; j ++){
				if (i * f[j] >= n) break;
				b[i * f[j]] = true;
				if (i % f[j] == 0) break;
			}
		}
		return x;
	}
}