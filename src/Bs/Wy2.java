package Bs;

import java.util.*;

public class Wy2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		if (n != 0) a[0] = sc.nextInt();
		for (int i = 1; i < n; i ++) a[i] = a[i - 1] + sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < m; i ++) {
			int now = sc.nextInt();
			int head = 0, tail = n - 1;
			while (head != tail) {
				int mid = (head + tail) / 2;
				if (a[mid] >= now) tail = mid; else head = mid + 1;
			}
			System.out.println(head + 1);
		}
		sc.close();
	}
}