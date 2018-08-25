package leetcode;

public class Solution96 {
	public static void main(String args[]){
		Solution96 s = new Solution96();
		System.out.println(s.numTrees(10));
	}
	public int numTrees(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int i = 1; i <= n; i ++)
			for (int j = 0; j < i; j ++) f[i] += f[j] * f[i - j - 1];
		return f[n];
	}
}