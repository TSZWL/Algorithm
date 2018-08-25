package Bs;

import java.util.*;

public class Hw2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] vv = sc.nextLine().split(",");
		String[] uu = sc.nextLine().split(",");
		int tot = sc.nextInt();
		sc.close();
		int[] v = new int[vv.length];
		int[] u = new int[uu.length];
		for (int i = 0; i < v.length; i ++) {
			v[i] = Integer.parseInt(vv[i]);
			u[i] = Integer.parseInt(uu[i]);
		}
		int[][] f = new int[v.length][tot + 1];
		for (int i = u[0]; i <= tot; i ++) f[0][i] = v[0]; 
		for (int i = 1; i < v.length; i ++)
			for (int j = 0; j <= tot; j ++) {
				f[i][j] = f[i - 1][j];
				if (j - u[i] >= 0) f[i][j] = Math.max(f[i][j], f[i - 1][j - u[i]] + v[i]);
			}
		System.out.println(f[v.length - 1][tot]);
	}
}