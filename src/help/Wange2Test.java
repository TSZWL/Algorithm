package help;

import java.util.Scanner;

/*
3
1 2 3
 */

public class Wange2Test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//a记录每个数的大小
		int n = sc.nextInt();
		long a[] = new long[100000]; 
		for (int i = 0; i < n; i ++)
			a[i] = sc.nextLong();
		
		long answer = -1;
		
		for (int i = 0; i <= n; i ++)
			for (int j = i; j <= n; j ++){
				long rlt = 0;
				for (int i1 = 0; i1 < i; i1 ++)
					rlt = rlt ^ a[i1];
				for (int j1 = j; j1 < n; j1 ++)
					rlt = rlt ^ a[j1];
				if (rlt > answer) answer = rlt;
			}
		System.out.println(answer);
		sc.close();
	}
}
