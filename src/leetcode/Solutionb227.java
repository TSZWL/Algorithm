package leetcode;

public class Solutionb227 {
	
	public static void main(String args[]){
		Solutionb227 s = new Solutionb227();
		System.out.println(s.calculate(" 3+5 / 2 "));
	}
	public int calculate(String s) {
		s = s.replace(" ", "");
		char[] c = s.toCharArray();
		int[] num = new int[c.length];
		char[] pos = new char[c.length];
		int l = 0, now = 0, t = 0;
		for (int i = 0; i < c.length; i ++)
			if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/'){
				num[l] = now;
				pos[l] = c[i];
				l ++;
				now = 0;
			} else {
				now = now * 10 + c[i] - '0';
			}
		num[l] = now;
		for (int i = 0; i < l; i ++)
			if (pos[i] == '*'){
				num[i + 1] *= num[i];
			} else if (pos[i] == '/'){
				num[i + 1] = num[i] / num[i + 1];
			} else {
				num[t] = num[i];
				pos[t] = pos[i];
				t ++;
			}
		num[t] = num[l];
		for (int i = 0; i < t; i ++)
			if (pos[i] == '+'){
				num[i + 1] += num[i];
			} else if (pos[i] == '-'){
				num[i + 1] = num[i] - num[i + 1];
			}
		return num[t];
	}
}