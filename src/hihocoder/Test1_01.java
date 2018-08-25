package hihocoder;

import java.util.Scanner;

public class Test1_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int p = 0; p < n; p++){
			
			int m = sc.nextInt();
			int[][] a = new int[50][2];
			for (int i=1;i<=m;i++){
				double d = sc.nextDouble();
				a[i][0] = (int)Math.round(d*2);
				a[i][1] = sc.nextInt();
			}
			
			//前几个，选了几个，余数
			int[][][] b = new int[51][4][10];
			
			for (int i=0;i<=m;i++)
				for (int j=0;j<4;j++)
					for (int l=0;l<10;l++) 
						b[i][j][l] = -100000000;
			b[0][0][0] = 0;
			
			for (int i=1;i<=m;i++)
				for (int j=0;j<4;j++)
					for (int l=0;l<10;l++){
						if (j == 0){
							b[i][j][l] = b[i-1][j][l];
							continue;
						}
						b[i][j][l] = maxx(b[i-1][j][l], b[i-1][j-1][(l+10000000-a[i][0])%10] + a[i][1]);
					}
			
			System.out.println(maxx(maxx(b[m][3][0], b[m][2][0]), maxx(b[m][1][0], b[m][0][0])));
		}
		sc.close();
	}

	private static int maxx(int i, int j) {
		if (i>j) return i; else return j;
	}

}
