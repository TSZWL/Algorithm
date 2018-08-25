package leetcode;

import java.util.*;

public class Solutionb556 {
	public static void main(String args[]){
		Solutionb556 s = new Solutionb556();
		System.out.println(s.nextGreaterElement(25431000));
	}
	public int nextGreaterElement(int n) {
		char[] c = (n + "").toCharArray();
		int l = c.length - 2;
		while (l >= 0 && c[l] >= c[l + 1]) l --;
		if (l < 0) return -1;
		int k = l + 1;
		while (k < c.length && c[k] > c[l]) k ++;
		k --;
		if (l == 0)
			while (c[k] == '0') k --;
		char t = c[l];
		c[l] = c[k];
		c[k] = t;
		Arrays.sort(c, l + 1, c.length);
		long r = Long.parseLong(new String(c));
		return r > Integer.MAX_VALUE ? -1 : (int)r;
	}
}