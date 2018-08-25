package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solutionb406 {
	
	public static void main(String args[]){
		Solutionb406 s = new Solutionb406();
		int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
		int[][] r = s.reconstructQueue(a);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i][0] + " " + r[i][1]);
	}
	//拓扑排序，用堆维护(?)
	//倒序Insert到列表里，小的数对大的数没有影响
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) return a[1] - b[1];
				return b[0] - a[0];
			}
		});
		List<int[]> r = new ArrayList<int[]>();
		for (int i = 0; i < people.length; i ++) r.add(people[i][1], people[i]);
		int[][] result = new int[people.length][];
		int n = 0;
		for (int[] x : r){
			result[n] = x;
			n ++;
		}
		return result;
	}
}