package leetcode;

import java.util.*;

public class Solutionb743 {
	
	public static void main(String args[]){
	}
	public int networkDelayTime(int[][] times, int N, int K) {
		int[] point = new int[N + 1];
		int[] next = new int[times.length];
		Arrays.fill(next, -1);
		Arrays.fill(point, -1);
		for (int i = 0; i < times.length; i ++) {
			next[i] = point[times[i][0]];
			point[times[i][0]] = i;
		}
		int[] q = new int[10001];
		int[] f = new int[N + 1];
		Arrays.fill(f, Integer.MAX_VALUE);
		boolean[] b = new boolean[N + 1];
		int head = 0, tail = 1;
		q[0] = K;
		f[K] = 0;
		b[K] = true;
		while (head < tail) {
			int l = point[q[head]];
			while (l != -1) {
				if (f[times[l][1]] > f[times[l][0]] + times[l][2]) {
					f[times[l][1]] = f[times[l][0]] + times[l][2];
					if (!b[times[l][1]]) {
						b[times[l][1]] = true;
						q[tail ++] = times[l][1];
					}
				}
				l = next[l];
			}
			b[q[head ++]] = false;
		}
		int ans = 0;
		for (int i = 1; i <= N; i ++) ans = Math.max(ans, f[i]);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}