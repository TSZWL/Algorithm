package leetcode;

public class Solutionb461 {
	
	public static void main(String args[]){
		Solutionb461 s = new Solutionb461();
		System.out.println(s.hammingDistance(1, 4));
	}
	public int hammingDistance(int x, int y) {
		int result = 0;
		int a = x ^ y;
		while (a != 0){
			result += a % 2;
			a = a >> 1;
		}
		return result;
	}
}