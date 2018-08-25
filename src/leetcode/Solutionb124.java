package leetcode;

public class Solutionb124 {
	public static void main(String args[]){
	}
	private int result = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		dfs(root);
		return result;
	}
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int i = dfs(root.left);
		int j = dfs(root.right);
		result = Math.max(result, i + j + root.val);
		return Math.max(root.val + Math.max(i, j), 0);
	}
}