package Bs;

import java.util.*;

public class Tt2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n == 0) {
			System.out.println(0);
			return;
		}
		int[][][] f = new int[n][n / 2 + 1][4];//Êý×Ö ×Ö·û Õý ·´À¨ºÅ
		if (n != 1) f[0][1][2] = 1;
		f[0][0][0] = 10;
		for (int i = 1; i < n; i ++)
			for (int j = 0; j <= n / 2; j ++) {
				long sum = f[i - 1][j][2];
				sum = (sum + f[i - 1][j][0] + f[i - 1][j][1]) * 10 % 1000000007;
				f[i][j][0] = (int)sum;
				f[i][j][1] = ((f[i - 1][j][0] + f[i - 1][j][3]) % 1000000007) * 2 % 1000000007;
				if (j != 0) f[i][j][2] = (f[i - 1][j - 1][1] + f[i - 1][j - 1][2]) % 1000000007;
				if (j != n / 2) f[i][j][3] = (f[i - 1][j + 1][0] + f[i - 1][j + 1][3]) % 1000000007;
			}
		System.out.println((f[n - 1][0][0] + f[n - 1][0][3]) % 1000000007);
	}
}