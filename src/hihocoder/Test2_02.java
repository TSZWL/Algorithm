package hihocoder;

import java.util.Scanner;

public class Test2_02 {

	public static void main(String[] args) {
		int[] prime = new int[1000001];
		boolean[] check = new boolean[1000001];
		int tot = 0;
		
		for (int i=0;i<1000001;i++) check[i] = false;
		
		for (int i=2;i<1000001;i++){
			if (!check[i]){
				prime[tot] = i;
				tot++;
			}
			for (int j=0;j<tot;j++){
				if (i*prime[j]>1000000) break;
				check[i*prime[j]] = true;
				if (i%prime[j] == 0) break;
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		sc.close();
		
		long x = 1, y = 1, z = 1;
		
		for (int i=0;i<tot;i++){
			int pn = 0, pm = 0;
			while (n%prime[i] == 0){
				pn++;n = n/prime[i];
			}
			while (m%prime[i] == 0){
				pm++;m = m/prime[i];
			}
			x = x * (pn + 1);
			y = y * (pm + 1);
			z = z * (minn(pn, pm) + 1);
		}
		if (n != 1) x = x * 2;
		if (m != 1) y = y * 2;
		long xy = x;xy = xy * y;
		
		for (int i=0;i<tot;i++)
			while ((xy%prime[i] == 0)&&(z%prime[i] == 0)){
				xy = xy/prime[i];
				z = z/prime[i];
			}
		System.out.println(xy+" "+z);
	}

	private static int minn(int i, int j) {
		if (i>j) return j; else return i;
	}

}
