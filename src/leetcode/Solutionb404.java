package leetcode;

public class Solutionb404 {
	
	public static void main(String args[]){
	}
	int result = 0;
	public int sumOfLeftLeaves(TreeNode root) {
		dfs(0, root);
		return result;
	}
	private void dfs(int b, TreeNode root){
		if (root == null) return;
		if (b == 1 && root.left == null && root.right == null){
			result += root.val;
			return;
		}
		dfs(0, root.right);
		dfs(1, root.left);
	}
}