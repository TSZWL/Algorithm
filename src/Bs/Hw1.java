package Bs;

import java.util.*;

public class Hw1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.nextLine().toCharArray();
		sc.close();
		for (char x : c)
			if (x >= 'a' && x <= 'z') System.out.print((char)(x - 32));
			else if (x >= 'A' && x <= 'Z') System.out.print((char)(x + 32));
			else System.out.print(x);
		System.out.println();
	}
}