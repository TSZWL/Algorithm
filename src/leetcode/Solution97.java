package leetcode;

public class Solution97 {
	
	public static void main(String args[]){
		Solution97 s = new Solution97();
		System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length()) return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();
		boolean[][] b = new boolean[c1.length + 1][c2.length + 1];
		b[0][0] = true;
		for (int i = 0; i <= c1.length; i ++)
			for (int j = 0; j <= c2.length; j ++){
				if (i < c1.length && c1[i] == c3[i + j]) b[i + 1][j] |= b[i][j];
				if (j < c2.length && c2[j] == c3[i + j]) b[i][j + 1] |= b[i][j];
			}
		return b[c1.length][c2.length];
	}
}