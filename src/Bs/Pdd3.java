package Bs;

import java.util.*;

public class Pdd3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] st = sc.nextLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);
		boolean[][] f = new boolean[n][n];
		for (int i = 0; i < n; i ++) {
			st = sc.nextLine().split(" ");
			for (String s : st) {
				f[i][Integer.parseInt(s)] = true;
			}
		}
		sc.close();
		int now = -1, num = 0;
		for (int i = 0; i < n; i ++)
			if (i != x && !f[x][i]) {
				int tot = 0;
				for (int j = 0; j < n; j ++)
					if (f[x][j] && f[i][j]) tot ++;
				if (tot > num) {
					num = tot;
					now = i;
				}
			}
		System.out.println(now);
	}
}