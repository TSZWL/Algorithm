package Bs;

import java.util.*;

public class Pdd1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		sc.close();
		int n = st.length() / 4;
		System.out.println(st.substring(0, n + 1));
		for (int i = 0; i < n - 1; i ++) {
			System.out.print(st.charAt(n * 4 - 1 - i));
			for (int j = 1; j < n; j ++) System.out.print(" ");
			System.out.println(st.charAt(n + 1 + i));
		}
		for (int i = n * 3; i >= n * 2; i --) System.out.print(st.charAt(i));
		System.out.println();
	}
}