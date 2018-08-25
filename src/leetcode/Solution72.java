package leetcode;

public class Solution72 {
	
	public static void main(String args[]){
		Solution72 s = new Solution72();
		System.out.println(s.minDistance("jaobfjo", "kjanfl"));
	}
	public int minDistance(String word1, String word2) {
		char[] a = (" " + word1).toCharArray();
		char[] b = (" " + word2).toCharArray();
		int[][] f = new int[a.length][b.length];
		for (int i = 1; i < a.length; i ++) f[i][0] = i;
		for (int i = 1; i < b.length; i ++) f[0][i] = i;
		for (int i = 1; i < a.length; i ++)
			for (int j = 1; j < b.length; j ++)
				if (a[i] == b[j])
					f[i][j] = f[i - 1][j - 1];
				else f[i][j] = 1 + Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]);
		return f[a.length - 1][b.length - 1];
	}
}