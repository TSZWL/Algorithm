package leetcode;

public class Solutionb188 {
	
	public static void main(String args[]){
		Solutionb188 s = new Solutionb188();
		int[] x = {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
		System.out.println(s.maxProfit(11, x));
	}
	public int maxProfit(int k, int[] prices) {
		if ((prices.length < 2) || (k == 0)) return 0;
		if (k > prices.length / 2){
			int result = 0;
			for (int i = 1; i < prices.length; i ++)
				if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
			return result;
		}
		int[][] f = new int[prices.length][k * 2 + 1];
		for (int i = 0; i < k; i ++) f[0][i * 2 + 1] = Integer.MIN_VALUE;
		f[0][1] = -prices[0];
		for (int i = 1; i < prices.length; i ++){
			for (int j = 0; j < k; j ++){
				int x = j * 2 + 1, y = x + 1;
				f[i][x] = Math.max(f[i - 1][x], f[i][x - 1] - prices[i]);
				f[i][y] = Math.max(f[i - 1][y], f[i][x] + prices[i]);
			}
		}
		return f[prices.length - 1][k * 2];
	}
}