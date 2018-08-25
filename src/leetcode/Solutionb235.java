package leetcode;

public class Solutionb235 {
	
	public static void main(String args[]){
	}
	TreeNode result = null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int max = Math.max(p.val, q.val);
		int min = Math.min(p.val, q.val);
		dfs(root, max, min);
		return result;
	}
	private void dfs(TreeNode root, int max, int min) {
		if (root == null) return;
		if (root.val >= min && root.val <= max){
			result = root;
			return;
		}
		if (root.val < min) dfs(root.right, max, min);
		if (root.val > max) dfs(root.left, max, min);
	}
}