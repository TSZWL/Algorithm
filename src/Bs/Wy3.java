package Bs;

import java.util.*;

public class Wy3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
		sc.close();
		String result = "";
		k --;
		while (k != 0) {
			long cal = 1;
			boolean[] b = new boolean[n];
			for (int i = m + 1; i < n + m; i ++) {
				cal = cal * i;
				boolean del = false;
				for (int j = 2; j < n; j ++)
					if (!b[j] && cal % j == 0) {
						cal = cal / j;
						b[j] = true;
						del = true;
					}
				if (!del && cal > k) break;
			}
			if (n == 0 || m == 0) break;
			if (cal <= k) {
				result += "z";
				k = k - (int)cal;
				m --;
			} else {
				result += "a";
				n --;
			}
		}
		if (k != 0) System.out.println(-1);
		else {
			System.out.print(result);
			for (int i = 0; i < n; i ++) System.out.print("a");
			for (int i = 0; i < m; i ++) System.out.print("z");
			System.out.println();
		}
	}
}