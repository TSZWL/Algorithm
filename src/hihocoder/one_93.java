package hihocoder;

import java.util.Scanner;

public class one_93 {

	public static void main(String[] args) {
		int[] prime = new int[1000001];
		boolean[] check = new boolean[1000001];
		int tot = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0;i<=n;i++) check[i] = false;
		
		for (int i=2;i<=n;i++){
			if (!check[i]){
				prime[tot] = i;
				tot++;
			}
			for (int j=0;j<tot;j++){
				if (i*prime[j]>n) break;
				check[i*prime[j]] = true;
				if (i%prime[j] == 0) break;
			}
		}
		
		System.out.println(tot);
		
		sc.close();
	}
}
