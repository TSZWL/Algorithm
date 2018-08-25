package leetcode;

public class Solutionb516 {
	public static void main(String args[]){
		Solutionb516 s = new Solutionb516();
		System.out.println(s.longestPalindromeSubseq("abbc"));
	}
	public int longestPalindromeSubseq(String s) {
		char[] c = s.toCharArray();
		int l = c.length;
		int[][] f = new int[l][l];
		for (int i = 0; i < l; i ++) f[i][i] = 1;
		for (int i = 1; i < l; i ++)
			for (int j = 0; j < l - i; j ++)
				if (c[j] == c[j + i]) f[j][j + i] = f[j + 1][j + i - 1] + 2;
				else f[j][j + i] = Math.max(f[j + 1][j + i], f[j][j + i - 1]);
		return f[0][l - 1];
	}
}