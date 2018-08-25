package Bs;

import java.util.*;

public class Wy1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int total = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i ++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i ++) {
			int x = sc.nextInt();
			if (x == 1) {
				total += a[i];
				a[i] = 0;
			}
		}
		sc.close();
		int now = 0;
		for (int i = 0; i < k; i ++) now += a[i];
		int max = now;
		for (int i = k; i < n; i ++) {
			now = now + a[i] - a[i - k];
			max = Math.max(max, now);
		}
		System.out.println(total + max);
	}
}