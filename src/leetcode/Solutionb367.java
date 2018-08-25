package leetcode;

public class Solutionb367 {
	
	public static void main(String args[]){
		Solutionb367 s = new Solutionb367();
		System.out.println(s.isPerfectSquare(15));
	}
	public boolean isPerfectSquare(int num) {
		if (num == Math.pow(Math.floor(Math.sqrt(num)), 2)) return true;
		return false;
	}
}