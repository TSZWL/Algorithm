package leetcode;

public class Solutionb172 {
	
	public static void main(String args[]){
		Solutionb172 s = new Solutionb172();
		System.out.println(s.countDigitOne(1410065408));
	}
	public int countDigitOne(int n) {
		if (n < 1) return 0;
		int result = 0;
		long x = 1;
		while (x <= n){
			long y = x * 10;
			result += (n - (n % y)) / 10;
			int z = (int)(n % y / x);
			if (z > 1) result += x;
			else if (z == 1) result += n % x + 1;
			x = x * 10;
		}
		return result;
	}
}