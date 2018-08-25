package leetcode;

public class Solutionb368 {
	
	public static void main(String args[]){
	}
	//就差线性筛了
	public int minSteps(int n) {
		int result = 0;
		for (int i = 2; i <= n; i ++)
			while (n % i == 0) {
				n = n / i;
				result += i;
				if (n == 1) return result;
			}
		return result;
	}
}