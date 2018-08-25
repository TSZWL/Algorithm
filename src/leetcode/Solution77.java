package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
	
	public static void main(String args[]){
		Solution77 s = new Solution77();
		List<List<Integer>> x = s.combine(4, 2);
		for (List<Integer> i : x){
			for (int j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> now = new ArrayList<Integer>();
	public List<List<Integer>> combine(int n, int k) {
		dfs(n, k, 0, 0);
		return result;
	}
	private void dfs(int n, int k, int x, int y) {
		if (n - x < k - y) return;
		if (k == y){
			result.add(new ArrayList<>(now));
			return;
		}
		for (int i = x; i < n; i ++){
			now.add(i + 1);
			dfs(n, k, i + 1, y + 1);
			now.remove(now.size() - 1);
		}
	}
}