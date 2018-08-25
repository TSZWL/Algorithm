package leetcode;

import java.util.*;

public class Solutionb103 {
	
	public static void main(String args[]){
	}
	//同b102，其实完全可以用List<List<Integer>>直接写。。。。
	Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		dfs(root, 0);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (Iterator<Integer> it = m.keySet().iterator(); it.hasNext(); ){
			result.add(m.get(it.next()));
		}
		return result;
	}
	private void dfs(TreeNode root, int i) {
		if (root == null) return;
		if (!m.containsKey(i)) m.put(i, new ArrayList<Integer>());
		if (i % 2 == 1){
			m.get(i).add(0, root.val);
		} else {
			m.get(i).add(root.val);
		}
		dfs(root.left, i + 1);
		dfs(root.right, i + 1);
	}
}