package leetcode;

public class Solutionb415 {
	public static void main(String args[]){
		Solutionb415 s = new Solutionb415();
		System.out.println(s.addStrings("1", "9"));
	}
	public String addStrings(String num1, String num2) {
		if (num2.length() > num1.length()){
			String c = num2;
			num2 = num1;
			num1 = c;
		}
		char[] ch = num1.toCharArray();
		char[] ch2 = num2.toCharArray();
		for (int i = 0; i < ch.length; i ++) ch[i] -= 48;
		int q = num1.length() - num2.length();
		for (int i = 0; i < num2.length(); i ++) ch[i + q] += ch2[i] - 48;
		for (int i = ch.length - 1; i > 0; i --) {
			ch[i - 1] += ch[i] / 10;
			ch[i] %= 10;
		}
		if (ch[0] >= 10){
			char[] result = new char[ch.length + 1];
			result[0] = '1';result[1] = (char) (ch[0] + 38);
			for (int i = 2; i <= ch.length; i ++) result[i] = (char) (ch[i - 1] + 48);
			return String.valueOf(result);
		}
		for (int i = 0; i < ch.length; i ++) ch[i] += 48;
		return String.valueOf(ch);
	}
}