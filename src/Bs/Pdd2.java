package Bs;

import java.util.*;

public class Pdd2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] st = sc.nextLine().toCharArray();
		sc.close();
		int tot = 0;
		for (int i = 0; i < st.length - 1; i ++) {
			int x1 = 0, x2 = 0;
			if (check(st, 0, i, -1)) x1 ++;
			if (check(st, i + 1, st.length - 1, -1)) x2 ++;
			for (int j = 0; j < i; j ++) if (check(st, 0, i, j)) x1 ++;
			for (int j = i + 1; j < st.length - 1; j ++) if (check(st, i + 1, st.length - 1, j)) x2 ++;
			tot += x1 * x2;
		}
		System.out.println(tot);
	}

	private static boolean check(char[] st, int p, int r, int j) {
		if (j == -1) {
			if (r != p && st[p] == '0') return false;
			return true;
		}
		if (p != j && st[p] == '0') return false;
		if (st[r] == '0') return false;
		return true;
	}
	
/*
	private static int dfs(char[] st, int pos, int point, int we) {
		if (pos == st.length) {
			if (point == 1 && st[st.length - 1] == '0') return 0;
			return 1;
		}
		if (st[pos] == '0' && point == 0 && we == 0) {
			return dfs(st, pos + 1, 1, 0) + dfs(st, pos + 1, 0, 0);
		} else if (point == 1) {
			int tot = dfs(st, pos + 1, 1, we + 1);
			if (we != 0 && st[pos] != '0') tot += dfs(st, pos + 1, 0, 0);
			return tot;
		} else {
			int tot = dfs(st, pos + 1, 0, we + 1);
			if (pos != st.length - 1) {
				tot += dfs(st, pos + 1, 0, 0) + dfs(st, pos + 1, 1, 0);
			}
			return tot;
		}
	}
*/
}