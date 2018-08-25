package leetcode;

import java.util.*;

public class Solutionb120 {
	public static void main(String args[]){
	}
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] r = new int[1001];
		for (int i = 0; i < triangle.size(); i ++){
			List<Integer> l = triangle.get(i);
			if (i != 0) r[i] = l.get(i) + r[i - 1];
			for (int j = l.size() - 2; j > 0; j --)
				r[j] = Math.min(r[j], r[j - 1]) + l.get(j);
			r[0] = l.get(0) + r[0];
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < triangle.size(); i ++) result = Math.min(result, r[i]);
		return result;
	}
}