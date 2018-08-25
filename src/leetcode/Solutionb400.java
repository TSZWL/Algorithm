package leetcode;

public class Solutionb400 {
	
	public static void main(String args[]){
		Solutionb400 s = new Solutionb400();
		System.out.println(s.findNthDigit(2147483647));
	}
	public int findNthDigit(int n) {
		int x = 9, c = 1;
		while (true){
			long a = (long)x * c;
			if (n <= a){
				n --;
				x = x / 9 + n / c;
				return String.valueOf(x).charAt(n % c) - '0';
			}
			n -= a;
			x *= 10;
			c ++;
		}
	}
}