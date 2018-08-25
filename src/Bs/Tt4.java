package Bs;

import java.util.*;

public class Tt4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] st = sc.nextLine().split(" ");
		int n = Integer.parseInt(st[0]), t = Integer.parseInt(st[1]);
		int[] a = new int[n];
		st = sc.nextLine().split(" ");
		for (int i = 0; i < n; i ++) a[i] = Integer.parseInt(st[i]);
		sc.close();
		if (t >= n) {
			System.out.println(n);
			return;
		}
		int[] f = new int[n];
		f[0] = 1;
		for (int i = 1; i < n; i ++)
			for (int j = 0; j < i; j ++)
				if (a[j] > a[i]) f[j] = Math.max(f[j], f[i] + 1);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i ++) max = Math.max(max, f[i]);
		System.out.println(Math.min(n - max + t, n));
	}
}