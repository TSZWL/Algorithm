package leetcode;

public class Solution43 {
	public static void main(String args[]){
		Solution43 s = new Solution43();
		System.out.println(s.multiply("43", "324123"));
	}
	public String multiply(String num1, String num2) {
		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();
		for (int i = 0; i < c1.length; i ++) c1[i] -= 48;
		for (int i = 0; i < c2.length; i ++) c2[i] -= 48;
		int[] result = new int[222];
		int l = c1.length + c2.length - 2;
		for (int i = 0; i < c1.length; i ++)
			for (int j = 0; j < c2.length; j ++)
				result[l - i - j] += c1[i] * c2[j];
		for (int i = 0; i < result.length - 1; i ++){
			result[i + 1] += result[i] / 10;
			result[i] %= 10;
		}
		int head = 221;
		while ((result[head] == 0) && (head > 0)) head --;
		String r = "";
		for (int i = head; i >= 0; i --) r += result[i];
		return r;
	}
}