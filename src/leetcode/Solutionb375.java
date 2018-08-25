package leetcode;

public class Solutionb375 {
	public static void main(String args[]){
		Solutionb375 s = new Solutionb375();
		System.out.println(s.getMoneyAmount(100));
	}
	//分割次数导致结果出错
	/*public int getMoneyAmount(int n) {
		int[] f = new int[n + 1];
		f[1] = 0;
		f[2] = 1;
		for (int i = 3; i <= n; i ++){
			f[i] = Integer.MAX_VALUE;
			for (int j = (i + 1) / 2; j < i; j ++) 
				f[i] = Math.min(f[i], j + Math.max(f[j - 1], f[i - j] + j * (int)Math.floor(Math.log10(i - j) / Math.log10(2))));
			System.out.println(i+" "+f[i]);
		}
		return f[n];
	}*/
	public int getMoneyAmount(int n) {
		int[][] f = new int[n + 2][n + 1];
		for (int i = 2; i <= n; i ++)
			for (int j = 1; j < n - i + 2; j ++){
				f[j][i] = Integer.MAX_VALUE;
				for (int l = 0; l < i; l ++)
					f[j][i] = Math.min(j + l + Math.max(f[j][l], f[j + l + 1][i - l - 1]), f[j][i]);
			}
		return f[1][n];
	}
}