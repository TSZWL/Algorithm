package leetcode;

import java.util.*;

public class Solutionb241 {
	
	public static void main(String args[]){
		Solutionb241 s = new Solutionb241();
		List<Integer> r = s.diffWaysToCompute("2*3-4*5+1+1+1+1");
		for (int x : r) System.out.println(x);
	}
	Map<String, List<Integer>> m = new HashMap<String, List<Integer>>();
	public List<Integer> diffWaysToCompute(String input) {
		if (input.length() == 0) return new ArrayList<Integer>();
		int l = 0, now = 0;
		int[] num = new int[1001];
		int[] cal = new int[1001];
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i ++)
			if (c[i] > '9' || c[i] < '0'){
				num[l] = now;
				now = 0;
				if (c[i] == '+') cal[l] = 1;
				else if (c[i] == '-') cal[l] = -1;
				else cal[l] = 0;
				l ++;
			} else {
				now = now * 10 + c[i] - '0';
			}
		num[l] = now;
		l ++;
		return dfs(num, cal, 0, l - 1);
	}
	private List<Integer> dfs(int[] num, int[] cal, int x, int y) {
		if (m.containsKey(x + " " + y)){
			return m.get(x + " " + y);
		}
		List<Integer> r = new ArrayList<Integer>();
		if (x == y){
			r.add(num[x]);
			return r;
		}
		for (int i = x; i < y; i ++){
			List<Integer> aa = dfs(num, cal, x, i);
			List<Integer> bb = dfs(num, cal, i + 1, y);
			if (cal[i] == 0){
				for (int a : aa)
					for (int b : bb) r.add(a * b);
			} else {
				for (int a : aa)
					for (int b : bb) r.add(a + cal[i] * b);
			}
		}
		m.put(x + " " + y, r);
		return r;
	}
}