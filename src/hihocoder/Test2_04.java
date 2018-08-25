/*
������Sij��ʾ���Ͻ���Aij���Ӿ���ĺ͡� 
��ô��������Ҫ�����ʣ� 
1. Sij + N �� M = Si+1,j+1 
2. ��y>=nʱ��S1,y=S1,y+1����x>=mʱ��Sx,1=Sx+1,1��

��������1������ֻҪ֪��S11��ֵ����ôS11,S22,S33...�����Խ����ϵ��Ӿ������Щ��K�ı�������O(1)�����ֻҪ��һ��ͬ�෽��S11+xnm=0 mod K��ͬ��֪��S12���Եõ�S23,S34,S45...

��������2������ֻҪ��S11,S12,S13...S1n��S21,S31,S41...Sm1��O(N+M)���Խ�������Щ�Ӿ�����K�ı������С�

���ÿ���Ӿ�����Ϳ���O(1)�ó����ҹ�������ѧ������ͣ���

�ܵ�ʱ�临�Ӷ���O(N+M)��
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
