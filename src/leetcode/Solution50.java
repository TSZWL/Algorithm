package leetcode;

public class Solution50 {
	
	public static void main(String args[]){
		Solution50 s = new Solution50();
		System.out.println(s.myPow(8.88023, 3));
	}
	//return (n%2==0)?  myPow(x*x, n/2) : x*myPow(x*x, n/2);
	public double myPow(double x, int n) {
		return Math.pow(x, n);
	}
}