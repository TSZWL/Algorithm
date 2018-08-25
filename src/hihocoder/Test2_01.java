package hihocoder;

import java.util.Scanner;

public class Test2_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] a = new int[1001];
		int n = sc.nextInt();
		for (int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		sc.close();
		int t = n - 1;
		if (n!=1)
			while ((a[t] > a[t-1])&&(t!=1)) t--;
		for (int i = 0;i < t-1;i++)
			System.out.print(a[i]+" ");
		if (n!=1) System.out.println(a[t-1]);
			else System.out.println(a[0]);
	}
}
