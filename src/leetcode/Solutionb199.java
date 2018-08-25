package leetcode;

import java.util.*;

public class Solutionb199 {
	
	public static void main(String args[]){
	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		dfs(root, 1, result);
		return result;
	}
	private void dfs(TreeNode root, int i, List<Integer> result) {
		if (root == null) return;
		if (i > result.size()) result.add(root.val);
		dfs(root.right, i + 1, result);
		dfs(root.left, i + 1, result);
	}
}