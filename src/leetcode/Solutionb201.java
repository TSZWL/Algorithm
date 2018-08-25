package leetcode;

public class Solutionb201 {
	
	public static void main(String args[]){
	}
	public int rangeBitwiseAnd(int m, int n) {
		int now = 1, result = 0;
		while (m != 0 && n != 0){
			int a = m & 1;
			int b = n & 1;
			if (a == b){
				if (a == 1) result += now;
			} else result = 0;
			now = now << 1;
			m = m >> 1;
			n = n >> 1;
		}
		if (m != 0 || n != 0) return 0;
		return result;
	}
}