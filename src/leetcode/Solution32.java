package leetcode;

public class Solution32 {
	
	public static void main(String args[]){
		Solution32 s = new Solution32();
		System.out.println(s.longestValidParentheses("(()"));
	}
	public int longestValidParentheses(String s) {
		int[] f = new int[s.length() * 2 + 1];
		int now = s.length(), result = 0;
		f[now] = 1;
		for (int i = 0; i < s.length(); i ++){
			if (s.charAt(i) == '('){
				now ++;
				f[now] = i + 2;
			} else {
				now --;
				if (f[now] == 0) f[now] = i + 2;
				result = Math.max(result, i + 2 - f[now]);
			}
		}
		return result;
	}
}