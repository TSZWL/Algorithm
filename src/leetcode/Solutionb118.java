package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb118 {
	public static void main(String args[]){
	}
	public List<List<Integer>> generate(int numRows) {
		int[] r = new int[numRows + 1];
		r[0] = 1;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i ++){
			for (int j = i; j > 0; j --) r[j] += r[j - 1];
			List<Integer> a = new ArrayList<Integer>();
			for (int j = 0; j <= i; j ++) a.add(r[j]);
			result.add(a);
		}
		return result;
	}
}