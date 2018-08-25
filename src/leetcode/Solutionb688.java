package leetcode;

public class Solutionb688 {
	public static void main(String args[]){
		Solutionb688 s = new Solutionb688();
		System.out.println(s.knightProbability(8, 30, 6, 4));
	}
	public double knightProbability(int N, int K, int r, int c) {
		double f[][][] = new double[2][N][N];
		f[0][r][c] = 1;
		int k = 0;
		int[] x = {1, 1, 2, 2, -1, -1, -2, -2};
		int[] y = {2, -2, 1, -1, 2, -2, 1, -1};
		for (int a = 0; a < K; a ++) {
			for (int i = 0; i < N; i ++)
				for (int j = 0; j < N; j ++) {
					f[1 - k][i][j] = 0;
					for (int l = 0; l < 8; l ++) {
						int xx = i + x[l], yy = j + y[l];
						if (xx >= 0 && xx < N && yy >= 0 && yy < N) f[1 - k][i][j] += f[k][xx][yy] / 8;
					}
				}
			k = 1 - k;
		}
		double tot = 0;
		for (int i = 0; i < N; i ++)
			for (int j = 0; j < N; j ++) tot += f[k][i][j];
		return tot;
	}
}