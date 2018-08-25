package leetcode;

import java.util.*;

public class Solutionb386 {
	
	public static void main(String args[]){
		Solutionb386 s = new Solutionb386();
		List<Integer> x = s.lexicalOrder(192);
		for (int i : x) System.out.println(i);
	}
	public List<Integer> lexicalOrder(int n) {
		List<Integer> r = new ArrayList<Integer>();
		int now = 1;
		for (int i = 0; i < n; i ++) {
			r.add(now);
			if (n >= now * 10) now *= 10;
			else {
				if (now == n) now = now / 10 + 1; else now ++;
				while (now % 10 == 0) now /= 10;
			}
		}
		return r;
	}
}