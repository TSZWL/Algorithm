package leetcode;

public class Solutionb441 {
	
	public static void main(String args[]){
	}
	public int arrangeCoins(int n) {
		int j = 1;
		for (long i = 0; i <= n; i += j ++){}
		return j - 2;
	}
}