package leetcode;

public class Solutionb231 {
	
	public static void main(String args[]){
		Solutionb231 s = new Solutionb231();
		System.out.println(s.isPowerOfTwo(9));
	}
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		if (1073741824 % n == 0) return true;
		return false;
	}
}