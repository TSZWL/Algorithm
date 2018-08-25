package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
	
	public static void main(String args[]){
		Solution39 s = new Solution39();
		int[] a = {2, 3, 6, 7};
		List<List<Integer>> x = s.combinationSum(a, 7);
		for (List<Integer> i : x){
			for (int j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> now = new ArrayList<Integer>();
	int[] num = new int[1001], cnt = new int[1001];
	int n = 0, nownum = 0;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0) return null;
		Arrays.sort(candidates);
		n = candidates.length;
		for (int i = candidates.length - 1; i >= 0; i --) num[n - i - 1] = candidates[i];
		dfs(0, target);
		return result;
	}
	private void dfs(int i, int target) {
		if (nownum == target){
			result.add(new ArrayList<>(now));
			return;
		}
		for (int j = i; j < n; j ++){
			int head = 1;
			int tail = (target - nownum) / num[j];
			if ((j == n - 1) && (tail > 0)) head = tail;
			for (int l = 1; l < head; l ++){
				now.add(num[j]);
				nownum += num[j];
			}
			for (int l = head; l <= tail; l ++){
				now.add(num[j]);
				nownum += num[j];
				dfs(j + 1, target);
			}
			for (int l = 1; l <= tail; l ++){
				now.remove(now.size() - 1);
				nownum -= num[j];
			}
		}
	}
}