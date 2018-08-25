package leetcode;

public class Solutionb132 {
	
	public static void main(String args[]){
		Solutionb132 s = new Solutionb132();
		String a = "abbab";
		System.out.println(s.minCut(a));
	}
	//很容易想到的是n^2的方法
	public int minCut(String s) {
		int l = s.length();
		boolean[][] b = new boolean[l][l];
		for (int i = 0; i < l; i ++) b[i][i] = true;
		for (int i = 0; i < l - 1; i ++) b[i + 1][i] = true;
		for (int i = 1; i < l; i ++)
			for (int j = 0; j < l - i; j ++)
				if (s.charAt(j) == s.charAt(i + j)) b[j][i + j] = b[j + 1][i + j - 1];
		int[] f = new int[l + 1];
		for (int i = 1; i <= l; i ++) f[i] = Integer.MAX_VALUE;
		for (int i = 1; i <= l; i ++)
			for (int j = 0; j < i; j ++)
				if (b[j][i - 1])
					f[i] = Math.min(f[i], f[j] + 1);
		return f[l] - 1;
	}
	/* Method2: DP, "Extend" method for Palindrome Problem
	if (s == null || s.length() == 0) return 0;
	int len = s.length();
	int[] dp = new int[len];
	for (int i = 0; i < len; i++) dp[i] = i;
	for (int i = 0; i < len; i++) {
		extend(s, i, i, dp);
		extend(s, i, i + 1, dp);
	}
	return dp[len - 1];
	public void extend(String s, int i, int j, int[] dp) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			if (i == 0) dp[j] = 0;
			else dp[j] = Math.min(dp[j], dp[i - 1] + 1);
			i--;
			j++;
		}
	}*/
}