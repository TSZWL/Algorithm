package leetcode;

public class Solutionb397 {
	
	public static void main(String args[]){
	}
	public int integerReplacement(int n) {
		int result = 0;
		while (n != 1)
			if ((n & 1) == 0){
				n = n >> 1;
				result ++;
			} else if ((n & 2) == 0){
				n = n >> 2;
				result += 3;
			} else {
				if (n == 3) return result + 2;
				n = (n >> 2) + 1;
				result += 3;
			}
		return result;
	}
}