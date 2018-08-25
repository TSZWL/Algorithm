package codeforces;

import java.util.Scanner;
//É¾³ýpackage£¬¸Ä³ÉMain
public class t347_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String i=sc.nextLine();
		String[] x = i.split(" ");
		if (x[0].equals(x[1])) System.out.println(x[0]);
		else System.out.println("1");
		sc.close();
	}

}
