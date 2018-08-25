package leetcode;

public class Solutionb629 {
	
	public static void main(String args[]){
		Solutionb629 s = new Solutionb629();
		System.out.println(s.kInversePairs(3, 1));
	}
	public int kInversePairs(int n, int k) {
		if (k == 0) return 1;
		int[][] sum = new int[2][k + 1];
		for (int i = 0; i <= k; i ++) sum[0][i] = 1;
		int now = 0;
		for (int i = 2; i <= n; i ++){
			now = 1 - now;
			sum[now][0] = 1;
			for (int j = 1; j <= k; j ++){
				long s = sum[now][j - 1];
		 		s += sum[1 - now][j];
				if (j - i >= 0) s -= sum[1 - now][j - i];
				s = s % 1000000007;
				sum[now][j] = (int)s;
			}
		}
		return (sum[now][k] - sum[now][k - 1] + 1000000007) % 1000000007;
	}
}