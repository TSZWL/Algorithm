package leetcode;

public class Solutionb309 {
	
	public static void main(String args[]){
		Solutionb309 s = new Solutionb309();
		int[] x = {1, 2, 4};
		System.out.println(s.maxProfit(x));
	}
	public int maxProfit(int[] prices) {
		if (prices.length < 2) return 0;
		int[][] f = new int[prices.length][2];
		f[0][1] = -prices[0];
		f[1][0] = Math.max(0, prices[1] - prices[0]);
		f[1][1] = Math.max(-prices[0], -prices[1]);
		for (int i = 2; i < prices.length; i ++){
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
			f[i][1] = Math.max(f[i - 1][1], f[i - 2][0] - prices[i]);
		}
		return f[prices.length - 1][0];
	}
}