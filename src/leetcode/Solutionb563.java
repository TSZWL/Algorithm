package leetcode;

public class Solutionb563 {
	
	public static void main(String args[]){
	}
	private int result = 0;
	public int findTilt(TreeNode root) {
		dfs(root);
		return result;
	}
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int i = dfs(root.left);
		int j = dfs(root.right);
		result += Math.abs(i - j);
		return i + j + root.val;
	}
}