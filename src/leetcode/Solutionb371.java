package leetcode;

public class Solutionb371 {
	
	public static void main(String args[]){
		Solutionb371 s = new Solutionb371();
		System.out.println(s.getSum(15, 451));
	}
	public int getSum(int a, int b) {
		if (b == 0) return a;
		int sum = a ^ b, inc = (a & b) << 1;
		return getSum(sum, inc);
	}
}