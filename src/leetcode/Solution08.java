package leetcode;

public class Solution08 {
	public static void main(String args[]){
	}
	public int myAtoi(String str) {
		int l = str.length(), i;
		char c = 'a';
		for (i = 0; i < l; i++){
			c = str.charAt(i);
			if (c != ' ') break;
		}
		if (i == l) return 0;
		if (((c < '0') || (c > '9')) && (c != '+') && (c != '-')) return 0;
		long rlt = 0, o = 1;
		if ((c == '+') || (c == '-')){
			if (c == '-') o = -1;
			i++;
		}
		while (i < l){
			c = str.charAt(i);
			if ((c < '0') || (c > '9')) break;
			rlt = rlt * 10 + c - 48;
			if (rlt > 2147483647) break;
			i++;
		}
		if (rlt * o > 2147483647) return 2147483647;
		if (rlt * o < -2147483648) return -2147483648;
		return (int)(rlt * o);
	}
}