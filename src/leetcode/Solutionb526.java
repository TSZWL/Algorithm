package leetcode;

public class Solutionb526 {
	
	public static void main(String args[]){
		Solutionb526 s = new Solutionb526();
		System.out.println(s.countArrangement(15));
	}
	public int countArrangement(int N) {
		boolean[] b = new boolean[N + 1];
		return dfs(N, N, b);
	}
	//ʹ��downto����������ʱ��
	//��swap��������Ԫ�أ�������ѭ��ɨ��b[i]���Լ�������ʱ��
	private int dfs(int n, int t, boolean[] b) {
		if (n == 0) return 1;
		int total = 0;
		for (int i = t; i > 0; i --)
			if (!b[i] && (i % n == 0 || n % i == 0)){
				b[i] = true;
				total += dfs(n - 1, t, b);
				b[i] = false;
			}
		return total;
	}
}