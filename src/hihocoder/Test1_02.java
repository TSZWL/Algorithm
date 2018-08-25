package hihocoder;

import java.util.Scanner;

public class Test1_02 {
	
	public static int n;
	public static int[] next = new int[1000001];
	public static int[] point = new int[1000001];
	public static int[] a = new int[1000001];
	public static int[] b = new int[1000001];
	public static int bi = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		n = sc.nextInt();
		n = sc.nextInt();
		
		int[][] x = new int[1000][2];
		int[][] y = new int[1000][2];
		
		for (int i=0;i<n;i++){
			x[i][0] = sc.nextInt();
			y[i][0] = sc.nextInt();
			x[i][1] = sc.nextInt();
			y[i][1] = sc.nextInt();
		}
		
		boolean[][] foo = new boolean[1000][4];
		boolean[] get = new boolean[1000];
		
		for (int i=0;i<1000;i++)
			for (int j=0;j<4;j++)
				foo[i][j] = true;
		
		for (int i=1;i<n;i++)
			for (int j=0;j<i;j++){
				if ((x[i][1]<=x[j][0])||(y[i][1]<=y[j][0])||(x[i][0]>=x[j][1])||(y[i][0]>=y[j][1])){
					continue;
				}
				if ((x[i][0]<=x[j][0])&&(y[i][0]<=y[j][0])&&(x[i][1]>x[j][0])&&(y[i][1]>y[j][0])){
					foo[j][0] = false;
				}
				if ((x[i][0]<x[j][1])&&(y[i][0]<=y[j][0])&&(x[i][1]>=x[j][1])&&(y[i][1]>y[j][0])){
					foo[j][1] = false;
				}
				if ((x[i][0]<=x[j][0])&&(y[i][0]<y[j][1])&&(x[i][1]>x[j][0])&&(y[i][1]>=y[j][1])){
					foo[j][2] = false;
				}
				if ((x[i][0]<x[j][1])&&(y[i][0]<y[j][1])&&(x[i][1]>=x[j][1])&&(y[i][1]>=y[j][1])){
					foo[j][3] = false;
				}
				bi++;
				a[bi] = j;
				b[bi] = i;
				next[bi] = point[a[bi]];
				point[a[bi]] = bi;
			}
		
		for (int i=0;i<n;i++){
			get[i] = foo[i][0]|foo[i][1]|foo[i][2]|foo[i][3];
		}
		
		int rlt = -1,tt = 0;
		
		for (int i=0;i<1000;i++)
			if (get[i]){
				int ans = sou(i);
				if (ans>rlt){
					rlt = ans;
					tt = i+1;
				}
			}
		System.out.println(rlt+" "+tt);
		
		sc.close();
	}


	private static int sou(int s) {
		int[] q = new int[1000];
		boolean[] bb = new boolean[1000];
		for (int i=0;i<n;i++) bb[i] = false;
		bb[s] = true;
		q[0] = s;
		int head = 0,tail = 0;
		while (head<=tail){
			int l = point[q[head]];
			while (l>0){
				if (!bb[b[l]]){
					bb[b[l]] = true;
					tail++;
					q[tail] = b[l];
				}
				l = next[l];
			}
			head++;
		}

		int rr = 0;
		for (int i=0;i<1000;i++)
			if (bb[i]) rr++;
		return rr;	
	}
}
