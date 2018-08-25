package leetcode;

public class Solution91 {
	
	public static void main(String args[]){
		Solution91 s = new Solution91();
		System.out.println(s.numDecodings("12121"));
	}
	public int numDecodings(String s) {
		int l = s.length();
		if (l == 0) return 0;
		int[] f = new int[l + 1];
		f[0] = 1;
		for (int i = 1; i <= l; i ++){
			if (s.charAt(i - 1) != '0') f[i] += f[i - 1];
			if (i > 1){
				int j = Integer.parseInt(s.substring(i - 2, i));
				if (j > 9 && j < 27) f[i] += f[i - 2];
			}
		}
		return f[l];
	}
}