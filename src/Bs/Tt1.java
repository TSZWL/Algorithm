package Bs;

import java.util.*;

public class Tt1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = Integer.parseInt(sc.nextLine());
		int[] father = new int[n + 1];
		for (int i = 1; i <= n; i ++) father[i] = i;
		for (int i = 1; i <= n; i ++) {
			String[] st = sc.nextLine().split(" ");
			for (String s : st) {
				int xx = Integer.parseInt(s);
				if (xx == 0) break;
				int x = fath(father, xx), y = fath(father, i);
				if (x != y) father[x] = y;
			}
		}
		sc.close();
		boolean[] b = new boolean[n + 1];
		for (int i = 1; i <= n; i ++)
			if (!b[fath(father, i)]) {
				ans ++;
				b[fath(father, i)] = true;
			}
		System.out.println(ans);
	}
	
	private static int fath(int[] father, int i) {
		if (father[i] == i) return i;
		father[i] = fath(father, father[i]);
		return father[i];
	}
}