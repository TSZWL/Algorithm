package leetcode;

public class Solutionb168 {
	public static void main(String args[]){
		Solutionb168 s = new Solutionb168();
		System.out.println(s.convertToTitle(28));
	}
	public String convertToTitle(int n) {
		String result = "";
		while (n != 0){
			result = (char)(65 + (n - 1) % 26) + result;
			n = (n - 1) / 26;
		}
		return result;
	}
}