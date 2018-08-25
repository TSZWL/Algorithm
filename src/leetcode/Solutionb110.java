package leetcode;

public class Solutionb110 {
	public static void main(String args[]){
	}
	public boolean isBalanced(TreeNode root) {
		return dfs(root, 0) == -1 ? false : true;
	}
	private int dfs(TreeNode root, int h) {
		if (root == null) return h;
		int i = dfs(root.left, h + 1);
		if (i == -1) return -1;
		int j = dfs(root.right, h + 1);
		if (j == -1) return -1;
		return Math.abs(i - j) < 2 ? Math.max(i, j) : -1;
	}
}