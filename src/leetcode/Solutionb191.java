package leetcode;

public class Solutionb191 {
	
	public static void main(String args[]){
		Solutionb191 s = new Solutionb191();
		System.out.println(s.hammingWeight(2147483647 + 1));
	}
	public int hammingWeight(int n) {
		int x = 1, result = 0;
		if ((n & x) != 0) result ++;
		for (int i = 1; i <= 31; i ++){
			x = x << 1;
			if ((n & x) != 0) result ++;
		}
		return result; 
	}
}