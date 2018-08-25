package help;

import java.util.Scanner;

/*
2 3 2

111
010

100
100

2 3 4

111
010

111
110

111
000

111
100
 */

public class Wange1 {
	
	private static int flag[] = new int[100];
	private static int num[] = new int[100];
	private static int bnum[] = new int[1<<15];
	private static int map[][][] = new int[10][10][6];
	private static int n, m, k, fin, now, nowrlt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//n,m,k代表字符的长宽和数量
		//map记录字符整体信息
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < k; i ++){
			sc.nextLine();
			for (int j = 0; j < n; j ++){
				String st = sc.nextLine();
				for (int l = 0; l < m; l ++){
					map[j][l][i] = st.charAt(l) - 48;
				}
			}
		}
		
		//flag记录不同字符间的异同
		//num记录不同字符的数量（可能优化用）
		for (int i = 0; i < n; i ++){
			for (int j = 0; j < m; j ++){
				int l = i * m + j;
				flag[l] = 0;
				num[l] = 0;
				for (int l1 = 0; l1 < k - 1; l1 ++)
					for (int l2 = l1 + 1; l2 < k; l2 ++){
						int a = map[i][j][l1] ^ map[i][j][l2];
						flag[l] = (flag[l] << 1) + a;
						num[l] += a;
					}
			}
		}
		
		for (int i = 0; i < n * m; i ++)
			for (int j = 0; j < n * m; j ++)
				if (num[j] < num[i]){
					int s = num[j];
					num[j] = num[i];
					num[i] = s;
					s = flag[i];
					flag[i] = flag[j];
					flag[j] = s;
				}
		
		fin = (1 << (k * (k - 1) / 2)) - 1;
		nowrlt = 0;
		//bnum检查达成某个目标所需的最少字符数
		for (int i = 0; i <= fin; i ++)
			bnum[i] = 2147483647;
		bnum[0] = 0;
		check(0);
		System.out.println(bnum[fin]);
		sc.close();
	}

	//第几个字符
	private static void check(int x) {
		if (nowrlt == fin) return;
		if (x == n * m) return;
		int a = now;
		now = now | flag[x];
		if ((a != now) && (nowrlt + 1 < bnum[now])){
			nowrlt ++;
			bnum[now] = nowrlt;
			check(x + 1);
			nowrlt --;
		}
		now = a;
		check(x + 1);
	}
}
