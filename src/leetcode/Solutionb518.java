package leetcode;

public class Solutionb518 {
	public static void main(String args[]){
		Solutionb518 s = new Solutionb518();
		int[] a = {1,2,5};
		System.out.println(s.change(5, a));
	}
	public int change(int amount, int[] coins) {
		int[] f = new int[amount + 1];
		f[0] = 1;
		for (int i = 0; i < coins.length; i ++)
			for (int j = 0; j <= amount - coins[i]; j ++) f[j + coins[i]] += f[j];
		return f[amount];
	}
}