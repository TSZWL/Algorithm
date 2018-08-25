package leetcode;

public class Solutionb530 {
	
	public static void main(String args[]){
	}
	private int now = -1, result = Integer.MAX_VALUE;
	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		return result;
	}
	private void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.left);
		if (now == -1) now = root.val;
		else {
			result = Math.min(result, root.val - now);
			now = root.val;
		}
		dfs(root.right);
	}
}