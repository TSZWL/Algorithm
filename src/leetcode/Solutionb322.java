package leetcode;

public class Solutionb322 {
	
	public static void main(String args[]){
		Solutionb322 s = new Solutionb322();
		int[] a = {2};
		System.out.println(s.coinChange(a, 1));
	}
	//�о������ȶ���Ҫ�졣��
	//���ԣ��ø������Ĳ�һ�����ţ��������������ƾͲ���������
	//��submission��Ȼ����+��֦�ȶ�����졣��
	public int coinChange(int[] coins, int amount) {
		int[] f = new int[amount + 1];
		for (int i = 1; i <= amount; i ++) f[i] = amount + 1;
		for (int i = 1; i <= amount; i ++)
			for (int j = 0; j < coins.length; j ++)
				if (coins[j] <= i) f[i] = Math.min(f[i], f[i - coins[j]] + 1);
		return f[amount] == amount + 1 ? -1 : f[amount];
	}
}