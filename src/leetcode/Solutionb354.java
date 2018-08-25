package leetcode;

import java.util.*;

public class Solutionb354 {
	
	public static void main(String args[]){
		Solutionb354 s = new Solutionb354();
		int[][] a = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(s.maxEnvelopes(a));
	}
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length, max = 0;
		Arrays.sort(envelopes, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		int[] f = new int[n + 1], g = new int[n];
		for (int i = 1; i <= n; i ++) f[i] = Integer.MAX_VALUE;
		for (int i = 0; i < n; ){
			g[i] = find(f, 0, max, envelopes[i][1]) + 1;
			int j = i + 1;
			for (; j < n && envelopes[i][0] == envelopes[j][0]; j ++){
				g[j] = find(f, 0, max, envelopes[j][1]) + 1;
			}
			for (int l = i; l < j; l ++){
				max = Math.max(max, g[l]);
				f[g[l]] = Math.min(f[g[l]], envelopes[l][1]);
			}
			i = j;
		}
		return max;
	}
	private int find(int[] f, int head, int tail, int l) {
		while (head < tail){
			int mid = (head + tail >> 1) + 1;
			if (f[mid] < l) head = mid; else tail = mid - 1;
		}
		return head;
	}
}