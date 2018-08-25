package leetcode;

public class Solutionb409 {
	
	public static void main(String args[]){
		Solutionb409 s = new Solutionb409();
		System.out.println(s.longestPalindrome("abccccdd"));
	}
	public int longestPalindrome(String s) {
		int[] f = new int[150];
		int result = 0, odd = 0;
		for (char c : s.toCharArray()) f[c] ++;
		for (int i = 'A'; i <= 'z'; i ++)
			if (f[i] % 2 == 0){
				result += f[i];
			} else {
				odd = 1;
				result += f[i] - 1;
			}
		return result + odd;
	}
}