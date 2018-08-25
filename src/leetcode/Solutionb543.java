package leetcode;

public class Solutionb543 {
	public static void main(String args[]){
	}
	private int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		dfs(root);
		return max;
	}
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int i = dfs(root.left);
		int j = dfs(root.right);
		max = Math.max(max, i + j);
		return Math.max(i, j) + 1;
	}
}