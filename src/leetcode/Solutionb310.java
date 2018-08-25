package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb310 {
	public static void main(String args[]){
		Solutionb310 s = new Solutionb310();
		int[][] a = {{1, 0}, {1, 2}, {1, 3}};
		List<Integer> r = s.findMinHeightTrees(4, a);
		for (int x : r) System.out.println(x);
	}
	//很简单的想法，直接从连接点数只为1的点开始剥离
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<Integer>();
		if (n < 3){
			for (int i = 0; i < n; i ++) result.add(i);
			return result;
		}
		int[] point = new int[n];
		int[] num = new int[n];
		int[] next = new int[edges.length * 2 + 1];
		int[] x = new int[edges.length * 2 + 1];
		int[] y = new int[edges.length * 2 + 1];
		for (int i = 0; i < edges.length; i ++){
			int e = i * 2 + 1;
			x[e] = edges[i][0];
			y[e] = edges[i][1];
			next[e] = point[x[e]];
			point[x[e]] = e;
			e = i * 2 + 2;
			x[e] = edges[i][1];
			y[e] = edges[i][0];
			next[e] = point[x[e]];
			point[x[e]] = e;
			num[edges[i][0]] ++;
			num[edges[i][1]] ++;
		}		
		int head = 0, tail = 0;
		int[] q = new int[n];
		for (int i = 0; i < n; i ++)
			if (num[i] == 1){
				q[tail] = i;
				tail ++;
			}
		while (true){
			if (n - tail < 3) break;
			int a = head, b = tail;
			for (int i = a; i < b; i ++){
				int l = point[q[head]];
				while (l != 0){
					num[y[l]] --;
					if (num[y[l]] == 1){
						q[tail] = y[l];
						tail ++;
					}
					l = next[l];
				}
				head ++;
			}
		}
		for (int i = 0; i < n; i ++) 
			if (num[i] > 1) result.add(i);
		return result;
	}
}