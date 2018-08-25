/*
我们设Sij表示左上角是Aij的子矩阵的和。 
那么有两个重要的性质： 
1. Sij + N × M = Si+1,j+1 
2. 当y>=n时，S1,y=S1,y+1。当x>=m时，Sx,1=Sx+1,1。

根据性质1，我们只要知道S11的值，那么S11,S22,S33...这条对角线上的子矩阵和哪些是K的倍数可以O(1)求出。只要解一个同余方程S11+xnm=0 mod K。同理知道S12可以得到S23,S34,S45...

根据性质2，我们只要求S11,S12,S13...S1n和S21,S31,S41...Sm1这O(N+M)条对角线上哪些子矩阵是K的倍数就行。

最后每个子矩阵求和可以O(1)得出（找规律用数学方法求和）。

总的时间复杂度是O(N+M)。
 */


package hihocoder;

import java.util.Scanner;

public class Test2_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int p = 0; p < q; p++){
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			sc.close();
			
			int[][] f = new int[100001][2];
			
			long f11 = 0;
			for (int i=1;i<=maxx(n, m);i++){
				f11 = f11 + i * (maxx(n+1-i, 0) + maxx(m+1-i, 0) - 1);
			}
			f[1][1] =(int) f11 % k;
			f11 = n;f11 = f11 * m;
			
			int[] a = new int[200001];
			for (int i=1;i<200000;i++) a[i] = (a[i-1] + i) % k;
			
			int round = 0;
			int all =(int) f11 % k;
			boolean end = true;
			
			for (int ij = 3; ij < 100001; ij++){
				for (int i = 1; i < ij; i++){
					int j = ij - i;
					if (i != ij - 1){
						if ((i >= j)&&(i+n >= j+m))
							f[i][round] = (f[i][1-round] + all - a[maxx(j+m-i-1, 0)] + k) % k;
						if ((i >= j)&&(i+n < j+m))
							f[i][round] = (f[i][1-round] + a[i+n-j+2] - a[i-j] + k) % k;
						if ((i < j)&&(i+n >= j+m))
							f[i][round] = (f[i][1-round] + a[i+n-j] - a[i+n-j-m] + k) % k;
						if ((i < j)&&(i+n < j+m))
							f[i][round] = (f[i][1-round] + a[maxx(i+n-j, 0)]) % k;
					} else {
						if ((i >= j)&&(i+n >= j+m))
							f[i][round] = (f[i-1][1-round] + a[maxx(j+m-i, 0)]) % k;
						if ((i >= j)&&(i+n < j+m))
							f[i][round] = (f[i-1][1-round] + all - a[i+n-j] + a[i-j] + k) % k;
						if ((i < j)&&(i+n >= j+m))
							f[i][round] = (f[i-1][1-round] + all - a[i+n-j] + a[i+n-j-m] + k) % k;
						if ((i < j)&&(i+n < j+m))
							f[i][round] = (f[i-1][1-round] + all - a[maxx(i+n-j, 0)] + k) % k;
					}
					System.out.println(f[i][round]);
					if (f[i][round] == 0){
						System.out.println(i+" "+j);
						end = false;
						break;
					}
				}
				if (!end) break;
				round = 1 - round;
			}
		}
	}

	private static int maxx(int i, int j) {
		if (i>j) return i; else return j;
	}
}
