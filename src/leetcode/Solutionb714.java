package leetcode;

public class Solutionb714 {
	
	public static void main(String args[]){
		Solutionb714 s = new Solutionb714();
		int[] a = {1, 3, 7, 5, 10, 3};
		System.out.println(s.maxProfit(a, 3));
	}
	//不用数组
	public int maxProfit(int[] prices, int fee) {
		if (prices.length == 0) return 0;
		int[][] f = new int[prices.length][2];
		f[0][1] = -prices[0] - fee;
		for (int i = 1; i < prices.length; i ++) {
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
			f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i] - fee);
		}
		return f[prices.length - 1][0];
	}
}