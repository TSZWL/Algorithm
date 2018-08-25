package leetcode;

public class Solution05 {
	public static void main(String args[]){
	}
	//直接扩展就好
	public String longestPalindrome(String s) {
		int l = s.length();
		boolean[][] b = new boolean[1001][2];
		int set = 0, len = 1;
		for (int i = 0; i < l; i++){
			b[i][0] = true;
			b[i][1] = true;
		}
		for (int i = 2; i <= l; i++){
			int k = i % 2;
			for (int j = 0; j <= l - i; j++)
				if ((b[j + 1][k]) && (s.charAt(j) == s.charAt(j + i - 1))){
					b[j][k] = true;
					len = i;
					set = j;
				} else b[j][k] = false;
		}
		return s.substring(set, set + len);
	}
}