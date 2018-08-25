package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
	
	public static void main(String args[]){
		Solution40 s = new Solution40();
		int[] a = {10, 1, 2, 7, 6, 1, 5};
		List<List<Integer>> x = s.combinationSum2(a, 8);
		for (List<Integer> i : x){
			for (int j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> now = new ArrayList<Integer>();
	int[] num = new int[1001], cnt = new int[1001];
	int n = 0, nownum = 0;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0) return null;
		Arrays.sort(candidates);
		int count = 1;
		for (int i = candidates.length - 2; i >= 0; i --)
			if (candidates[i] != candidates[i + 1]){
				num[n] = candidates[i + 1];
				cnt[n] = count;
				count = 1;
				n ++;
			} else count ++;
		num[n] = candidates[0];
		cnt[n] = count;
		dfs(0, target);
		return result;
	}
	private void dfs(int i, int target) {
		if (nownum == target){
			result.add(new ArrayList<>(now));
			return;
		}
		if (i > n) return;
		int j = 0;
		//可以直接循环避免递归层数过多
		dfs(i + 1, target);
		for (j = 1; j <= cnt[i]; j ++){
			now.add(num[i]);
			nownum += num[i];
			if (nownum > target) break; 
			dfs(i + 1, target);
		}
		if (j > cnt[i]) j --;
		for (int l = 0; l < j; l ++){
			now.remove(now.size() - 1);
			nownum -= num[i];
		}
	}
}