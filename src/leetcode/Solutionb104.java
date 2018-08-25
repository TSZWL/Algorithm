package leetcode;

public class Solutionb104 {
	
	public static void main(String args[]){
	}
	private int result = Integer.MIN_VALUE;
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		dfs(root, 1);
		return result;
	}
	private void dfs(TreeNode root, int i) {
		result = Math.max(result, i);
		if (root.left != null) dfs(root.left, i + 1);
		if (root.right != null) dfs(root.right, i + 1);
	}
}