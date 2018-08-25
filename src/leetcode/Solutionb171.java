package leetcode;

public class Solutionb171 {
	public static void main(String args[]){
		Solutionb171 s = new Solutionb171();
		System.out.println(s.titleToNumber("AA"));
	}
	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i ++)
			result = result * 26 + s.charAt(i) - 64;
		return result;
	}
}