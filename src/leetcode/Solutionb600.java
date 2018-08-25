package leetcode;

public class Solutionb600 {
	public static void main(String args[]){
		Solutionb600 s = new Solutionb600();
		System.out.println(s.findIntegers(1234567));
	}
	public int findIntegers(int num) {
		if (num == 0) return 1;
		int l = 0;
		int[] f = new int[33];
		int[][] g = new int[33][4];
		while (num != 0){
			f[l ++] = num & 1;
			num = num >> 1;
		}
		g[0][0] = 1;
		if (f[0] == 0) g[0][3] = 1; else g[0][1] = 1;
		for (int i = 1; i < l; i ++)
			if (f[i] == 0){
				g[i][0] = g[i - 1][0] + g[i - 1][1];
				g[i][2] = g[i - 1][2] + g[i - 1][3];
				g[i][3] = g[i - 1][0] + g[i - 1][2];
			} else {
				g[i][0] = g[i - 1][0] + g[i - 1][1] + g[i - 1][2] + g[i - 1][3];
				g[i][1] = g[i - 1][0];
				g[i][3] = g[i - 1][2];
			}
		return g[l - 1][0] + g[l - 1][1];
	}
}