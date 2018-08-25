package leetcode;

public class Solutionb122 {
	
	public static void main(String args[]){
		Solutionb122 s = new Solutionb122();
		int[] x = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(s.maxProfit(x));
	}
	//...在第i天买入第i+2天卖出，和在第i+1天做一下交易是同样的。。(递增情况下，波动也是逐日比较好)
	/*public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int[][] f = new int[prices.length][2];
		f[0][0] = 0;
		f[0][1] = -prices[0];
		for (int i = 1; i < prices.length; i ++){
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
			f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
		}
		return f[prices.length - 1][0];
	}*/
	public int maxProfit(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i ++)
			if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
		return result;
	}
}