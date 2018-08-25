package leetcode;

public class Solutionb129 {
	public static void main(String args[]){
	}
	private int result = 0;
	public int sumNumbers(TreeNode root) {
		dfs(root, 0);
		return result;
	}
	private void dfs(TreeNode root, int tot) {
		if (root == null) return;
		tot = tot * 10 + root.val;
		if (root.left == null && root.right == null){
			result += tot;
			return;
		}
		dfs(root.left, tot);
		dfs(root.right, tot);
	}
}