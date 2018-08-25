package Bs;

import java.util.Scanner;

public class Al {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] map = new int[n + 1][n + 1];
		int[] x = new int[n + 1];
		int[] y = new int[n + 1];
		for (int i = 1; i <= n; i ++) {
			String[] sp = sc.nextLine().split(",");
			x[i] = Integer.parseInt(sp[0]);
			y[i] = Integer.parseInt(sp[1]);
		}
		sc.close();
		for (int i = 0; i <= n; i ++)
			for (int j = 0; j <= n; j ++)
				map[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
		boolean[] b = new boolean[n + 1];
		b[0] = true;
		System.out.println(dfs(map, 0, 1, n + 1, b));
	}
	
	private static int dfs(int[][] map, int now, int dis, int tot, boolean[] b) {
		if (dis == tot) return map[0][now];
		int minDis = Integer.MAX_VALUE;
		for (int i = 1; i < tot; i ++) 
			if (!b[i]){
				b[i] = true;
				minDis = Math.min(minDis, map[now][i] + dfs(map, i, dis + 1, tot, b));
				b[i] = false;
			}
		return minDis;
	}
}
