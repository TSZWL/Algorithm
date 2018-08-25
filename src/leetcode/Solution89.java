package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {
	
	public static void main(String args[]){
		Solution89 s = new Solution89();
		List<Integer> x = s.grayCode(2);
		for (int i : x) System.out.println(i);
	}
	//¸ñÀ×ÂëgrayCode = i ^ (i >> 1)
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		if (n == 0) return result;
		int[] or = new int[n];
		int[] and = new int[n];
		int[] q = new int[1 << n];
		boolean[] b = new boolean[1 << n];
		for (int i = 0; i < n; i ++){
			or[i] = 1 << i;
			and[i] = (1 << n) - 1 - or[i];
		}
		b[0] = true;
		dfs(0, q, b, 0, (1 << n) - 1, and, or, n);
		for (int i = 1; i < 1 << n; i ++) result.add(q[i]);
		return result;
	}
	private boolean dfs(int n, int[] q, boolean[] b, int now, int t, int[] and, int[] or, int w) {
		b[n] = true;
		q[now] = n;
		if (now == t) return true;
		for (int i = 0; i < w; i ++){
			int j = n & and[i];
			int k = n | or[i];
			if (!b[j])
				if (dfs(j, q, b, now + 1, t, and, or, w)) return true;
			if (!b[k])
				if (dfs(k, q, b, now + 1, t, and, or, w)) return true;
		}
		b[n] = false;
		return false;
	}
}