package leetcode;

public class Solutionb547 {
	
	public static void main(String args[]){
	}
	public int findCircleNum(int[][] M) {
		boolean[] b = new boolean[M.length];
		int result = 0;
		for (int i = 0; i < M.length; i ++)
			if (!b[i]){
				b[i] = true;
				result ++;
				dfs(i, b, M);
			}
		return result;
	}
	private void dfs(int n, boolean[] b, int[][] m) {
		for (int i = 0; i < m.length; i ++)
			if (m[n][i] == 1 && !b[i]){
				b[i] = true;
				dfs(i, b, m);
			}
	}
}