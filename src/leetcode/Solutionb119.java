package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb119 {
	public static void main(String args[]){
		Solutionb119 s = new Solutionb119();
		List<Integer> r = s.getRow(3);
		for (int x : r) System.out.println(x);
	}
	public List<Integer> getRow(int rowIndex) {
		int[] r = new int[rowIndex + 1];
		r[0] = 1;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= rowIndex; i ++)
			for (int j = i; j > 0; j --) r[j] += r[j - 1];
		for (int i = 0; i <= rowIndex; i ++) result.add(r[i]);
		return result;
	}
}