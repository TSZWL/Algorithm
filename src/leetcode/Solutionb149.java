package leetcode;

import java.util.*;

public class Solutionb149 {
	
	public static void main(String args[]){
		Solutionb149 s = new Solutionb149();
		Point[] a = new Point[3];
		a[0] = new Point(0, 0);
		a[1] = new Point(-1, -1);
		a[2] = new Point(2, 2);
		System.out.println(s.maxPoints(a));
	}
	//Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
	public int maxPoints(Point[] points) {
		int n = points.length, result = 0;
		for (int i = 0; i < n; i ++){
			Map<String, Integer> map = new HashMap<String, Integer>();
			int num = 0, max = 0, m2 = 0;
			for (int j = 0; j < n; j ++)
				if (points[i].x == points[j].x && points[i].y == points[j].y){
					num ++;
				} else if (points[i].x == points[j].x){
					max ++;
				} else if (points[i].y == points[j].y){
					m2 ++;
				} else {
					int x = points[j].x - points[i].x;
					int y = points[j].y - points[i].y;
					int g = getGcd(x, y);
					x /= g;
					y /= g;
					if (x < 0){
						x = -x;
						y = -y;
					}
					String a = x + " " + y;
					if (!map.containsKey(a)) map.put(a, 1);
					else map.put(a, map.get(a) + 1);
				}
			max = Math.max(max, m2);
			for (Integer j : map.values()) max = Math.max(max, j);
			result = Math.max(result, max + num);
		}
		return result;
	}
	private int getGcd(int x, int y) {
		if (y == 0) return x;
		return getGcd(y, x % y);
	}
}