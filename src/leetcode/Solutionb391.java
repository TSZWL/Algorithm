package leetcode;

import java.util.*;

public class Solutionb391 {
	
	public static void main(String args[]){
	}
	Set<String> set = new HashSet<String>();
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles.length == 0) return true;
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
		int c = Integer.MIN_VALUE, d = Integer.MIN_VALUE;
		int tot = 0;
		for (int i = 0; i < rectangles.length; i ++){
			int[] x = rectangles[i];
			a = Math.min(a, x[0]);
			b = Math.min(b, x[1]);
			c = Math.max(c, x[2]);
			d = Math.max(d, x[3]);
			tot += (x[2] - x[0]) * (x[3] - x[1]);
			add(x[0] + " " + x[1]);
			add(x[0] + " " + x[3]);
			add(x[2] + " " + x[1]);
			add(x[2] + " " + x[3]);
		}
		if (tot != (c - a) * (d - b)) return false;
		if (set.size() != 4) return false;
		for (Iterator<String> it = set.iterator(); it.hasNext(); ){
			String[] y = it.next().split(" ");
			int[] x = {Integer.parseInt(y[0]), Integer.parseInt(y[1])};
			if (x[0] != a && x[0] != c) return false;
			if (x[1] != b && x[1] != d) return false;
		}
		return true;
	}
	public void add(String is){
		if (set.contains(is)) set.remove(is); else set.add(is);
	}
}