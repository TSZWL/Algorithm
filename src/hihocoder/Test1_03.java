package hihocoder;

import java.util.Scanner;

public class Test1_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][][] a = new int[51][51][51];
		int[][][] b = new int[51][51][51];
		int[][][] mina = new int[51][51][51];
		int[][][] minb = new int[51][51][51];
		int[][][] m = new int[51][51][51];
		
		for (int i=0;i<=50;i++)
			for (int j=0;j<=50;j++)
				for (int l=0;l<=50;l++) 
					m[i][j][l] = 100000000;
		m[0][0][0] = 0;
		mina[0][0][0] = -1;
		minb[0][0][0] = -1;
		
		for (int i=0;i<=50;i++)
			for (int j=0;j<=50;j++)
				for (int l=0;l<=50;l++){
					if (i!=0){
						int k1 = a[i-1][j][l] - maxx(mina[i-1][j][l], 1) - 1;
						int k2 = b[i-1][j][l] - maxx(minb[i-1][j][l], 1) - 1;
						if ((m[i-1][j][l] - k1 < m[i][j][l]) && (m[i-1][j][l] < m[i][j][l])){
							m[i][j][l] = maxx(m[i-1][j][l] - k1, m[i-1][j][l]);
							mina[i][j][l] = 1;
							minb[i][j][l] = minb[i-1][j][l];
							a[i][j][l] = k1;
							b[i][j][l] = b[i-1][j][l];
							if (k1 < 0){
								a[i][j][l] = 0;
								b[i][j][l] -= k1;
							}
						}
						if ((m[i-1][j][l] - k2 < m[i][j][l]) && (m[i-1][j][l] < m[i][j][l])){
							m[i][j][l] = maxx(m[i-1][j][l] - k2, m[i-1][j][l]);
							mina[i][j][l] = mina[i-1][j][l];
							minb[i][j][l] = 1;
							a[i][j][l] = a[i-1][j][l];
							b[i][j][l] = k2;
							if (k2 < 0){
								a[i][j][l] -= k2;
								b[i][j][l] = 0;
							}
						}
					}
					
					if (j!=0){
						int k1 = a[i][j-1][l] - maxx(mina[i][j-1][l], 2) - 1;
						int k2 = b[i][j-1][l] - maxx(minb[i][j-1][l], 2) - 1;
						if ((m[i][j-1][l] - k1 < m[i][j][l]) && (m[i][j-1][l] < m[i][j][l])){
							m[i][j][l] = maxx(m[i][j-1][l] - k1, m[i][j-1][l]);
							mina[i][j][l] = 2;
							minb[i][j][l] = minb[i][j-1][l];
							a[i][j][l] = k1;
							b[i][j][l] = b[i][j-1][l];
							if (k1 < 0){
								a[i][j][l] = 0;
								b[i][j][l] -= k1;
							}
						}
						if ((m[i][j-1][l] - k2 < m[i][j][l]) && (m[i][j-1][l] < m[i][j][l])){
							m[i][j][l] = maxx(m[i][j-1][l] - k2, m[i][j-1][l]);
							mina[i][j][l] = mina[i][j-1][l];
							minb[i][j][l] = 2;
							a[i][j][l] = a[i][j-1][l];
							b[i][j][l] = k2;
							if (k2 < 0){
								a[i][j][l] -= k2;
								b[i][j][l] = 0;
							}
						}
					}
					
					if (l!=0){
						int k1 = a[i][j][l-1] - maxx(mina[i][j][l-1], 3) - 1;
						int k2 = b[i][j][l-1] - maxx(minb[i][j][l-1], 3) - 1;
						if ((m[i][j][l-1] - k1 < m[i][j][l]) && (m[i][j][l-1] < m[i][j][l])){
							m[i][j][l] = maxx(m[i][j][l-1] - k1, m[i][j][l-1]);
							mina[i][j][l] = 3;
							minb[i][j][l] = minb[i][j][l-1];
							a[i][j][l] = k1;
							b[i][j][l] = b[i][j][l-1];
							if (k1 < 0){
								a[i][j][l] = 0;
								b[i][j][l] -= k1;
							}
						}
						if ((m[i][j][l-1] - k2 < m[i][j][l]) && (m[i][j][l-1] < m[i][j][l])){
							m[i][j][l] = maxx(m[i][j][l-1] - k2, m[i][j][l-1]);
							mina[i][j][l] = mina[i][j][l-1];
							minb[i][j][l] = 3;
							a[i][j][l] = a[i][j][l-1];
							b[i][j][l] = k2;
							if (k2 < 0){
								a[i][j][l] -= k2;
								b[i][j][l] = 0;
							}
						}
					}
				}
		
		for (int p = 0; p < n; p++){
			int i = sc.nextInt();
			int j = sc.nextInt();
			int l = sc.nextInt();
			System.out.println(m[i][j][l]);
		}
		sc.close();
	}

	private static int maxx(int i, int j) {
		if (i == -1) return 0;
		if (j == -1) return 0;
		if (i>j) return i; else return j;
	}

}
