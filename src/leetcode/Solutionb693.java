package leetcode;

public class Solutionb693 {
	
	public static void main(String args[]){
	}
	public boolean hasAlternatingBits(int n) {
		int x = n & 1;
		n = n >> 1;
		while (n != 0){
			int now = n & 1;
			if (now == x) return false;
			x = now;
			n = n >> 1;
		}
		return true;
	}
}