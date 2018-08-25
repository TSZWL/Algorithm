package leetcode;

public class Solutionb342 {
	
	public static void main(String args[]){
		Solutionb342 s = new Solutionb342();
		System.out.println(s.isPowerOfFour(16));
	}
	//return n > 0 && (n&(n-1))==0 && (n & 0x55555555) !=0;
	public boolean isPowerOfFour(int num) {
		if (num <= 0) return false;
		double x = Math.log10(num) / Math.log10(4);
		if (x - Math.floor(x) == 0) return true;
		return false;
	}
}