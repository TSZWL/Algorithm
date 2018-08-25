package leetcode;

public class Solutionb326 {
	
	public static void main(String args[]){
		Solutionb326 s = new Solutionb326();
		System.out.println(s.isPowerOfThree(9));
	}
	//or log(3)nÎªÕûÊý
	public boolean isPowerOfThree(int n) {
		if (n <= 0) return false;
		if (1162261467 % n == 0) return true;
		return false;
	}
}