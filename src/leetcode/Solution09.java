package leetcode;

public class Solution09 {
	public static void main(String args[]){
	}
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		int num = x, tot = 0;
		while (num > 0){
			tot = tot * 10 + num % 10;
			num = num / 10;
		}
		if (tot == x) return true; else return false;
	}
}