package hihocoder;

import java.util.Scanner;

public class Test2_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int p = 0; p < q; p++){
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int t = sc.nextInt();
			int[] a = new int[1001];
			
			for (int i=1;i<=n;i++) a[i] = sc.nextInt();
			sc.close();
			
			int[][] f = new int[1001][1001];
			
			for (int i=1;i<=n;i++)
				for (int j=0;j<=m;j++) f[i][j] = 1001;
			
			//j次答题过前i关用几次正确
			f[0][0] = 0;
			
			
			for (int i=1;i<=n;i++)
				for (int j=0;j<=m;j++)
					for (int l=0;l<=(a[i]-1)/s+1;l++){
						int tk = a[i]-(l*s)-1;
						int tl = tk/t;
						if (tk<0) tl = -1;
						int k = j-(tl+1+l);
						if (k>=0)
							f[i][j] = minn(f[i][j], f[i-1][k] + l);
					}
			
			
			//(a[i]-(l*t)-1)/s+1+l
			boolean x = false;
			for (int i=m;i>=0;i--)
				if (f[n][i]!=1001){
					System.out.println(f[n][i]);
					x = true;
					break;
				}
			if (!x) System.out.println("No");
		}
	}

	private static int minn(int i, int j) {
		if (i>j) return j; else return i;
	}

}
