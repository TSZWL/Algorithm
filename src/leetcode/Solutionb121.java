package leetcode;

public class Solutionb121 {
	
	public static void main(String args[]){
		Solutionb121 s = new Solutionb121();
		int[] x = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(s.maxProfit(x));
	}
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int min = prices[0], result = 0;
		for (int i = 1; i < prices.length; i ++){
			if (prices[i] - min > result) result = prices[i] - min;
			if (prices[i] < min) min = prices[i];
		}
		return result;
	}
}