package leetcode;

public class Solutionb664 {
	
	public static void main(String args[]){
		Solutionb664 s = new Solutionb664();
		System.out.println(s.strangePrinter("abababac"));
	}
	//k代表着把当前x~y分为x~k-1,k~y-1,y三段
	//初始值为f[j][j+i]=f[j][j+i-1]+1(不分割的情况
	public int strangePrinter(String s) {
		char[] c = s.toCharArray();
		if (c.length == 0) return 0;
		char[] g = new char[c.length];
		g[0] = c[0];
		int l = 1;
		for (int i = 1; i < c.length; i ++)
			if (c[i] != c[i - 1]) g[l ++] = c[i];
		int[][] f = new int[l][l];
		for (int i = 0; i < l; i ++) f[i][i] = 1;
		for (int i = 0; i < l - 1; i ++) f[i][i + 1] = 2;
		for (int i = 2; i < l; i ++)
			for (int j = 0; j < l - i; j ++){
				f[j][j + i] = f[j][j + i - 1] + 1;
				for (int k = j + 1; k < j + i; k ++)
					if (g[k - 1] == g[j + i]) f[j][j + i] = Math.min(f[j][j + i], f[j][k - 1] + f[k][j + i - 1]);
			}
		return f[0][l - 1];
	}
}