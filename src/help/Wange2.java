package help;

import java.util.Scanner;

/*
3
1 2 3
 */

public class Wange2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//a记录每个数的大小
		int n = sc.nextInt();
		long a[] = new long[100000]; 
		for (int i = 0; i < n; i ++)
			a[i] = sc.nextLong();
			
		//follow代表生成自动机的记录
		//map代表生成的自动机
		//road代表生成的二进制数
		//poi代表到达该点最靠后的位置信息
		long follow = 0;
		int num = 1;
		int road[] = new int[40];
		int poi[] = new int[4000000];
		int map[][] = new int[4000000][2];
		for (int i = n - 1; i >= 0; i --){
			long k = follow;
			for (int l = 39; l >= 0; l --){
				road[l] = (int)(k & 1);
				k = k >> 1;
			}
			int j = 0;
			for (int l = 0; l < 40; l ++){
				if (map[j][road[l]] == 0){
					map[j][road[l]] = num;
					poi[num] = i;
					num ++;
				}
				j = map[j][road[l]];
			}
			follow = follow ^ a[i];
		}
		
		long answer = follow;
		
		//follow顺序生成的异或值
		//road代表生成的二进制数
		follow = 0;
		for (int i = 0; i < n; i ++){
			long k = follow;
			for (int l = 39; l >= 0; l --){
				road[l] = 1 - (int)(k & 1);
				k = k >> 1;
			}
			int j = 0;
			k = 0;
			for (int l = 0; l < 40; l ++){
				if ((map[j][road[l]] == 0) || (poi[map[j][road[l]]] < i - 1)){
					j = map[j][1 - road[l]];
					k = k << 1;
				} else {
					j = map[j][road[l]];
					k = (k << 1) + 1;
				}
			}
			follow = follow ^ a[i];
			if (k > answer) answer = k;
		}
		System.out.println(answer);
		sc.close();
	}
}
