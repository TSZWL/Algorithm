package leetcode;

public class Solutionb123 {
	
	public static void main(String args[]){
		Solutionb123 s = new Solutionb123();
		int[] x = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(s.maxProfit(x));
	}
	//第一笔交易完最大值；第二笔买入最大值；第二笔卖出最大值
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int[][] f = new int[prices.length][3];
		int min = prices[0];
		f[0][1] = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i ++){
			f[i][0] = Math.max(f[i - 1][0], prices[i] - min);
			f[i][1] = Math.max(f[i - 1][1], f[i][0] - prices[i]);
			f[i][2] = Math.max(f[i - 1][2], f[i][1] + prices[i]);
			if (prices[i] < min) min = prices[i];
		}
		return f[prices.length - 1][2];
	}
}