package Bs;

import java.util.*;

public class Tt3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i ++) {
			boolean b = false;
			Set<String> hashSet = new HashSet<String>();
			int n = Integer.parseInt(sc.nextLine());
			for (int j = 0; j < n; j ++) {
				char[] st = sc.nextLine().trim().toCharArray();
				if (b) continue;
				String[] now = new String[st.length * 2];
				int tot = 0;
				for (int l = 0; l < st.length; l ++) {
					StringBuilder sb = new StringBuilder();
					for (int i1 = l; i1 < st.length; i1 ++) sb.append(st[i1]);
					for (int i1 = 0; i1 < l; i1 ++) sb.append(st[i1]);
					now[tot ++] = sb.toString();
					sb = new StringBuilder();
					for (int i1 = l - 1; i1 >= 0; i1 --) sb.append(st[i1]);
					for (int i1 = st.length - 1; i1 >= l ; i1 --) sb.append(st[i1]);
					now[tot ++] = sb.toString();
				}
				for (String xx : now)
					if (hashSet.contains(xx)) {
						b = true;
						System.out.println("Yeah");
						break;
					}
				for (String xx : now) hashSet.add(xx);
			}
			if (!b) System.out.println("Sad");
		}
		sc.close();	
	}
}