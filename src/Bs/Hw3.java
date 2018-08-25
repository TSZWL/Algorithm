package Bs;

import java.util.*;

public class Hw3 {
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String ori = sc.nextLine();
			String[] def = ori.trim().split(";");
			String find = sc.nextLine();
			sc.close();
			String[][] a = new String[def.length][2];
			if (!ori.contains(" " + find + ";")) {
				System.out.println("none");
				return;
			}
			for (int i = 0; i < def.length; i ++) {
				def[i] = def[i].trim();
				while (def[i].contains("  ")) def[i] = def[i].replaceAll("  ", " ");
				while (def[i].contains(" *")) def[i] = def[i].replaceAll(" \\*", "\\*");
				while (def[i].contains("long long")) def[i] = def[i].replaceAll("long long", "longlong");
				while (def[i].contains("long double")) def[i] = def[i].replaceAll("long double", "longdouble");
				while (def[i].contains("signed ")) def[i] = def[i].replaceAll("signed ", "signed");
				String[] x = def[i].split(" ");
				a[i][1] = x[1];
				a[i][0] = x[2];
			}
			while (true) {
				boolean c = false;
				for (int i = a.length - 1; i >= 0; i --)
					if (find.replaceAll("\\*", "").equals(a[i][0])) {
						find = find.replace(a[i][0], a[i][1]);
						c = true;
						break;
					}
				if (!c) break;
			}
			find = find.replaceAll("longlong", "long long");
			find = find.replaceAll("longdouble", "long double");
			find = find.replaceAll("signed", "signed ");
			for (char c : find.toCharArray())
				if (c == '*') System.out.print(" *"); else System.out.print(c);
			System.out.println();
		} catch(Exception e) {
			System.out.println("none");
		}
	}
}