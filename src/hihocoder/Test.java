package hihocoder;

import java.util.Scanner;
//É¾³ýpackage£¬¸Ä³ÉMain
public class Test {

	public static void main(String[] args) {
		System.out.println(114%10);
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		int j=sc.nextInt();
		String[][] a = new String[10][10];
		sc.nextLine();
		for (int x = 0; x < i; x++)
			for (int y = 0; y < j; y++)
				a[x][y] = sc.nextLine();
		for (int x = 0; x < i; x++){
			for (int y = 0; y < j; y++)
				System.out.print(a[x][y]+" ");
			System.out.println();
		}
		sc.close();
	}

}
