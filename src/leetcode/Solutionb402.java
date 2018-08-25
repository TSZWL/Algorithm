package leetcode;

public class Solutionb402 {
	
	public static void main(String args[]){
		Solutionb402 s = new Solutionb402();
		System.out.println(s.removeKdigits("100", 1));
	}
	public String removeKdigits(String num, int k) {
		char[] result = new char[num.length() - k];
		int tail = 0;
		for (char i : num.toCharArray()){
			while (tail > 0 && k > 0 && result[tail - 1] > i){
				k --;
				tail --;
			}
			if (tail > 0 && result[0] == '0') tail = 0;
			if (tail < result.length) result[tail ++] = i; else k --;
		}
		if (tail == 0) return "0";
		return new String(result, 0, tail);
	}
}