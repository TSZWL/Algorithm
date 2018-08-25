package leetcode;

import java.util.Arrays;

public class Solutionb451 {
	
	public static void main(String args[]){
		Solutionb451 s = new Solutionb451();
		System.out.println(s.frequencySort("Aabb"));
	}
	public String frequencySort(String s) {
		StringBuilder sb = new StringBuilder();
		int[][] f = new int[256][2];
		for (int i = 0; i < 256; i ++) f[i][1] = i;
		for (char c : s.toCharArray()) f[c][0] ++;
		Arrays.sort(f, (int[] a, int[] b) -> (b[0] - a[0]));
		for (int i = 0; i < 256; i ++)
			for (int j = 0; j < f[i][0]; j ++) sb.append((char)f[i][1]);
		return sb.toString();
	}
}