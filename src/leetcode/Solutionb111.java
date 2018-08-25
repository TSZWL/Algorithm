package leetcode;

public class Solutionb111 {
	
	public static void main(String args[]){
	}
	private int result = Integer.MAX_VALUE;
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		dfs(root, 1);
		return result;
	}
	private void dfs(TreeNode root, int i) {
		if (i == result) return;
		if (root.left == null && root.right == null){
			result = i;
			return;
		}
		if (root.left != null) dfs(root.left, i + 1);
		if (root.right != null) dfs(root.right, i + 1);
	}
}