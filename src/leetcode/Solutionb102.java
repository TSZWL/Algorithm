package leetcode;

import java.util.*;

public class Solutionb102 {
	
	public static void main(String args[]){
	}
	//HashMap用iterator遍历出来还是按照put顺序么？
	Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
	public List<List<Integer>> levelOrder(TreeNode root) {
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
		m.get(i).add(root.val);
		dfs(root.left, i + 1);
		dfs(root.right, i + 1);
	}
}