package leetcode;

public class Solutionb730 {
	
	public static void main(String args[]){
		Solutionb730 s = new Solutionb730();
		System.out.println(s.countPalindromicSubsequences("ddbddaadabbbdcdddabcbbcbadcbbbdadbcbccabddcbbcdcdacbdbabcadccdbdadaadbabbdcbbddadbccbabbcddddacdabac"));
	}
	//c[i]!=c[j](����i+����j-������i��j)
	//c[i]==c[j]:1.�м�û�е���c[i]��,*2+2
	//2.�м���1������c[i]��,*2+1;3.��2��,*2-�м��
	public int countPalindromicSubsequences(String S) {
		char[] c = S.toCharArray();
		int mod = 1000000007;
		int[][] f = new int[c.length][c.length];
		for (int i = 0; i < c.length; i ++) f[i][i] = 1;
		for (int i = 1; i < c.length; i ++)
			for (int j = 0; j < c.length - i; j ++)
				if (c[j] != c[j + i]){
					f[j][j + i] = ((f[j + 1][j + i] + f[j][j + i - 1]) % mod - f[j + 1][j + i - 1] + mod) % mod;
				} else {
					int x = j + 1, y = j + i - 1;
					while (x < y && c[x] != c[j]) x ++;
					while (x < y && c[y] != c[j]) y --;
					if (c[x] != c[j] || x > y){
						f[j][j + i] = (f[j + 1][j + i - 1] * 2 + 2) % mod;
					} else if (x == y) {
						f[j][j + i] = (f[j + 1][j + i - 1] * 2 + 1) % mod;
					} else f[j][j + i] = ((f[j + 1][j + i - 1] * 2) % mod - f[x + 1][y - 1] + mod) % mod;
				}
		return f[0][c.length - 1];
	}
}