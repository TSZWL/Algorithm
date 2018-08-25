package leetcode;

public class Solutionb233 {
	
	public static void main(String args[]){
		Solutionb233 s = new Solutionb233();
		System.out.println(s.trailingZeroes(200000000));
	}
	public int trailingZeroes(int n) {
		long x = 5;
		int result = 0;
		while (x <= n){
			result += n / x;
			x = x * 5;
		}
		return result;
	}
}