package leetcode;

import java.util.*;

public class Solutionb685 {
	
	public static void main(String args[]){
		Solutionb685 s = new Solutionb685();
		int[][] a = {{2,1},{3,1},{4,2},{1,4}};
		int[] r = s.findRedundantDirectedConnection(a);
		System.out.println(r[0] + " " + r[1]);
	}
	//������� ȫ��1���׺���1��2����
	//ȫ��1���׵����һ������ֵ��2���׵��жϵ�1�������Ƿ��ڻ���
	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int r = -1;
		for (int i = 0; i < edges.length; i ++){
			if (!m.containsKey(edges[i][1])){
				m.put(edges[i][1], i);
			} else {
				r = i;
			}
		}
		if (r != -1){
			int l = edges[m.get(edges[r][1])][0];
			while (l != edges[r][1]){
				if (m.containsKey(l)){
					l = edges[m.get(l)][0];
				} else {
					return edges[r];
				}
			}
			return edges[m.get(l)];
		}
		Set<Integer> set = new HashSet<Integer>();
		int l = 1;
		while (!set.contains(l)){
			set.add(l);
			l = edges[m.get(l)][0];
		}
		int start = l, result = m.get(l);
		l = edges[result][0];
		while (l != start){
			int e = m.get(l);
			result = Math.max(result, e);
			l = edges[e][0];
		}
		return edges[result];
	}
/*�ĳ��������һ�㡣��
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int[] m = new int[edges.length + 1];
		for (int i = 1; i <= edges.length; i ++) m[i] = -1;
		int r = -1;
		for (int i = 0; i < edges.length; i ++){
			if (m[edges[i][1]] == -1){
				m[edges[i][1]] = i;
			} else {
				r = i;
			}
		}
		if (r != -1){
			int l = edges[m[edges[r][1]]][0];
			while (l != edges[r][1]){
				if (m[l] != -1){
					l = edges[m[l]][0];
				} else {
					return edges[r];
				}
			}
			return edges[m[l]];
		}
		Set<Integer> set = new HashSet<Integer>();
		int l = 1;
		while (!set.contains(l)){
			set.add(l);
			l = edges[m[l]][0];
		}
		int start = l, result = m[l];
		l = edges[result][0];
		while (l != start){
			int e = m[l];
			result = Math.max(result, e);
			l = edges[e][0];
		}
		return edges[result];
	}
 */
}