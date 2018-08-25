package leetcode;

public class Solutionb236 {
	
	public static void main(String args[]){
	}
	TreeNode result = null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root, p, q);
		return result;
	}
	private int dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return 0;
		int x = 0;
		if (root == p) x = x | 1;
		if (root == q) x = x | 2;
		x = x | dfs(root.left, p, q);
		x = x | dfs(root.right, p, q);
		if (x == 3 && result == null) result = root;
		return x;
	}
}