package leetcode;

public class Solution59 {
	
	public static void main(String args[]){
		Solution59 s = new Solution59();
		int[][] a = s.generateMatrix(3);
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++) System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int[] x = {0, 1, 0, -1};
		int[] y = {1, 0, -1, 0};
		if (n == 0) return result;
		int a = 0, b = 0, c = 0, now = 1;
		while (now < n * n){
			int aa = a + x[c], bb = b + y[c];
			if (aa < 0 || bb < 0 || aa == n || bb == n || result[aa][bb] != 0){
				c = (c + 1) % 4;
				continue;
			}
			result[a][b] = now;
			now ++;
			a = aa;
			b = bb;
		}
		result[a][b] = now;
		return result;
	}
}