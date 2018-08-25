package leetcode;

public class Solutionb214 {
	
	public static void main(String args[]){
		Solutionb214 s = new Solutionb214();
		System.out.println(s.shortestPalindrome("aabba"));//aabbaabbaa
	}
	//先加翻转再做kmp(匹配串不能超过一半)
	//kmp处理匹配串结果f[x]的实质就是(x-f[x])~x(也就是后缀)与0~f[x](也就是前缀)完全匹配
	//其实不用判断j==l-1，直接两个串中间加一个#就好
	public String shortestPalindrome(String s) {
		if (s.length() == 0) return s;
		String st = s + new StringBuffer(s).reverse().toString();
		char[] c = st.toCharArray();
		int[] f = new int[c.length];
		f[0] = -1;
		int j = -1, l = s.length();
		for (int i = 1; i < c.length; i ++){
			while (j == l - 1 || j >= 0 && c[j + 1] != c[i]) j = f[j];
			if (c[j + 1] == c[i]) j ++;
			f[i] = j;
		}
		if (f[c.length - 1] >= l) return s;
		return new StringBuffer(s).reverse().toString() + s.substring(f[c.length - 1] + 1);
	}
/*
	public String shortestPalindrome(String s) {
		char[] c = s.toCharArray();
		char[] d = new char[c.length];
		for (int i = 0; i < c.length; i ++) d[i] = c[c.length - i - 1];
		for (int i = c.length; i >= 0; i --)
			if (check(c, d, i))
				return String.valueOf(d) + s.substring(i);
		return "";
	}
	private boolean check(char[] c, char[] d, int l) {
		int start = c.length - l;
		for (int i = 0; i < l; i ++)
			if (c[i] != d[start + i]) return false;
		return true;
	}
*/
}