package leetcode;

public class Solution10 {
	public static void main(String args[]){
		Solution10 s = new Solution10();
		System.out.println(s.isMatch("", "b*c*"));
	}
	public boolean isMatch(String s, String p) {
		int num1 = 1, num2 = 1;
		char[] f1 = new char[1001], f2 = new char[1001];
		boolean[] b1 = new boolean[1001], b2 = new boolean[1001];
		for (int i = 0; i < 1000; i ++){
			b1[i] = false;
			b2[i] = false;
		}
		while (!s.equals("")){
			f1[num1] = s.charAt(0);
			if ((s.length() > 1) && (s.charAt(1) == '*')) {
				b1[num1] = true;
				s = s.substring(2);
			} else s = s.substring(1);
			num1 ++;
		}
		while (!p.equals("")){
			f2[num2] = p.charAt(0);
			if ((p.length() > 1) && (p.charAt(1) == '*')) {
				b2[num2] = true;
				p = p.substring(2);
			} else p = p.substring(1);
			num2 ++;
		}
		boolean[][] f = new boolean[num1][num2];
		f[0][0] = true;
		int x = 1;
		while (b1[x] == true){
			f[x][0] = true;
			x ++;
		}
		x = 1;
		while (b2[x] == true){
			f[0][x] = true;
			x ++;
		}
		for (int i = 1; i < num1; i ++)
			for (int j = 1; j < num2; j ++){
				if (b1[i] == true){
					x = j;
					f[i][j] = f[i][j] || f[i - 1][j];
					while ((!f[i][j]) && (x > 0) && (isEqual(f1[i], f2[x]))){
						f[i][j] = f[i][j] || f[i - 1][x - 1];
						x --;
					}
				}
				if (b2[j] == true){
					x = i;
					f[i][j] = f[i][j] || f[i][j - 1];
					while ((!f[i][j]) && (x > 0) && (isEqual(f1[x], f2[j]))){
						f[i][j] = f[i][j] || f[x - 1][j - 1];
						x --;
					}
				}
				if ((b1[i] == false) && (b2[j] == false) && (isEqual(f1[i], f2[j]))) 
					f[i][j] = f[i][j] || f[i - 1][j - 1];
			}
		return f[num1 - 1][num2 - 1];
	}
	private boolean isEqual(char a, char b) {
		if (a == b) return true;
		if (a == '.') return true;
		if (b == '.') return true;
		return false;
	}
}