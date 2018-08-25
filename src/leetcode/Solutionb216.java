package leetcode;

import java.util.*;

public class Solutionb216 {
	
	public static void main(String args[]){
	}
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> now = new ArrayList<Integer>();
		dfs(9, 0, k, 0, n, result, now);
		return result;
	}
	private void dfs(int i, int a, int k, int b, int n, List<List<Integer>> result, List<Integer> now) {
		if (i + a < k) return;
		if (a == k || b == n){
			if (a == k && b == n) result.add(new ArrayList<>(now));
			return;
		}
		if (i + b <= n){
			now.add(i);
			dfs(i - 1, a + 1, k, i + b, n, result, now);
			now.remove(now.size() - 1);
		}
		dfs(i - 1, a, k, b, n, result, now);
	}
}