package leetcode;

public class Solutionb576 {
	
	public static void main(String args[]){
		Solutionb576 s = new Solutionb576();
		System.out.println(s.findPaths(1,3,3,0,1));
	}
	public int findPaths(int m, int n, int N, int i, int j) {
		long[][][] result = new long[2][m + 2][n + 2];
		int k = 0, r = 0;
		i ++;
		j ++;
		result[0][i][j] = 1;
		for (int i1 = 0; i1 < N; i1 ++){
			for (int l = 1; l < n + 1; l ++){
				r = (int)((r + result[k][1][l]) % 1000000007);
				r = (int)((r + result[k][m][l]) % 1000000007);
			}
			for (int l = 1; l < m + 1; l ++){
				r = (int)((r + result[k][l][1]) % 1000000007);
				r = (int)((r + result[k][l][n]) % 1000000007);
			}
			for (int j1 = 1; j1 < m + 1; j1 ++)
				for (int l = 1; l < n + 1; l ++)
					result[1 - k][j1][l] = (result[k][j1 + 1][l] + result[k][j1 - 1][l] 
							+ result[k][j1][l + 1] + result[k][j1][l - 1]) % 1000000007;
			k = 1 - k;
		}
		return r;
	}
}