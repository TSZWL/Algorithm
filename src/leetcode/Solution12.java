package leetcode;

public class Solution12 {
	public static void main(String args[]){
		Solution12 s = new Solution12();
		int a = 1931;
		System.out.println(s.intToRoman(a));
	}
	public String intToRoman(int num) {
		String[][] c = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
		{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
		{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
		{"","M","MM","MMM"}};
		return c[3][num / 1000] + c[2][num % 1000 / 100] + c[1][num % 100 / 10] + c[0][num % 10];
	}
}