package leetcode;

public class Solutionb633 {
	
	public static void main(String args[]){
		Solutionb633 s = new Solutionb633();
		System.out.println(s.judgeSquareSum(2147483646));
	}
	public boolean judgeSquareSum(int c) {
		for (int i = 0; (long)i * i <= c; i ++){
			int j = (int)Math.floor(Math.sqrt(c - i * i));
			if (j * j + i * i == c) return true;
		}
		return false;
	}
}