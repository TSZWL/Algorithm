package leetcode;

public class Solutionb718 {
	
	public static void main(String args[]){
	}
	public int findLength(int[] A, int[] B) {
		int[][] f = new int[A.length][B.length];
		int ans = 0;
		for (int i = 0; i < A.length; i ++)
			for (int j = 0; j < B.length; j ++)
				if (A[i] == B[j]) {
					if (i * j == 0) f[i][j] = 1;
					else f[i][j] = f[i - 1][j - 1] + 1;
					ans = Math.max(ans, f[i][j]);
				}
		return ans;
	}
}