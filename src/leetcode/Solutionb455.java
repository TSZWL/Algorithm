package leetcode;

import java.util.*;

public class Solutionb455 {
	public static void main(String args[]){
	}
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, head = 0;
		for (; i < g.length; i ++) {
			while (head < s.length && s[head] < g[i]) head ++;
			if (head == s.length) return i;
			head ++;
		}
		return i;
	}
}