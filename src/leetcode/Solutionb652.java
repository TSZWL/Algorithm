package leetcode;

import java.util.*;

public class Solutionb652 {
	
	public static void main(String args[]){
	}
	Map<String, Integer> map = new HashMap<String, Integer>();
	List<TreeNode> result = new ArrayList<TreeNode>();
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		dfs(root);
		return result;
	}
	private String dfs(TreeNode root) {
		if (root == null) return "n ";
		String r = dfs(root.left);
		r += dfs(root.right);
		r += root.val + " ";
		if (!map.containsKey(r)) map.put(r, 0);
		if (map.get(r) == 1) result.add(root);
		map.put(r, map.get(r) + 1);
		return r;
	}
}