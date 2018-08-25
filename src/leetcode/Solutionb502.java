package leetcode;

import java.util.*;

public class Solutionb502 {
	public static void main(String args[]){
	}
	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Queue<Integer> heap = new PriorityQueue<Integer>(Profits.length, (Integer a, Integer b) -> (b - a));
		int[][] f = new int[Profits.length][2];
		for (int i = 0; i < f.length; i ++) {
			f[i][0] = Capital[i];
			f[i][1] = Profits[i];
		}
		Arrays.sort(f, (int[] a, int[] b) -> (a[0] - b[0]));
		int head = 0;
		for (int i = 0; i < k; i ++) {
			while (head < f.length && f[head][0] <= W) heap.add(f[head ++][1]);
			if (heap.isEmpty()) return W;
			W += heap.poll();
		}
		return W;
	}
}