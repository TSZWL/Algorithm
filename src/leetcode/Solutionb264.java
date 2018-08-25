package leetcode;

public class Solutionb264 {
	
	public static void main(String args[]){
		Solutionb264 s = new Solutionb264();
		System.out.println(s.nthUglyNumber(1600));
	}
	//uglynum一定是由其他的uglynum扩展得来的，且一定在序列内
	//只有2 3 5.可以直接判断
	public int nthUglyNumber(int n) {
		int[] u = new int[n];
		u[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0, f2 = 2, f3 = 3, f5 = 5;
		for (int i = 1; i < n; i ++){
			int min = Math.min(f5, Math.min(f2, f3));
			u[i] = min;
			if (min == f2) f2 = u[++ p2] * 2;
			if (min == f3) f3 = u[++ p3] * 3;
			if (min == f5) f5 = u[++ p5] * 5;
		}
		return u[n - 1];
	}
/*
	for (int i = 2; i <= n; i ++){
		if (!b[i]) f[n ++] = i;
		for (int j = 1; j < n; j ++){
			if (i * f[j] > n) break;
			b[i * f[j]] = true;
			if (i % f[j] == 0) break;
		}
	}
*/
}