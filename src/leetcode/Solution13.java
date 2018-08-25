package leetcode;

public class Solution13 {
	public static void main(String args[]){
		Solution13 s = new Solution13();
		String a = "MCMXXXI";
		System.out.println(s.romanToInt(a));
	}
	public int romanToInt(String s) {
		String[][] c = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
		{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
		{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
		{"","M","MM","MMM"}};
		int[] a = {1, 10, 100, 1000, 0};
		for (int i = 3; i >= 0; i --)
			for (int j = c[i].length - 1; j >= 0; j --)
				if (s.startsWith(c[i][j])){
					s = s.substring(c[i][j].length());
					a[4] += j * a[i];
				}
		return a[4];
	}
}