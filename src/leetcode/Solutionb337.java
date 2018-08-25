package leetcode;

public class Solutionb337 {
	
	public static void main(String args[]){
	}
	//通过传递数组归并偷和不偷两种情况，大量减少搜索次数
	/*public int rob(TreeNode root) {
		if (root == null) return 0;
		return Math.max(dfs(root, true), dfs(root, false));
	}
	private int dfs(TreeNode root, boolean b) {
		int result = 0;
		if (root.left != null)
			if (b) result += dfs(root.left, !b);
			else result += Math.max(dfs(root.left, b), dfs(root.left, !b));
		if (root.right != null)
			if (b) result += dfs(root.right, !b);
			else result += Math.max(dfs(root.right, b), dfs(root.right, !b));
		if (b) result += root.val;
		return result;
	}*/
	public int rob(TreeNode root) {
		if (root == null) return 0;
		int[] x = dfs(root);
		return Math.max(x[0], x[1]);
	}
	private int[] dfs(TreeNode root) {
		int[] result = new int[2];
		int[] x = {0, 0}, y = {0, 0};
		if (root.left != null) x = dfs(root.left);
		if (root.right != null) y = dfs(root.right);
		result[0] = Math.max(x[0], x[1]) + Math.max(y[0], y[1]);
		result[1] = x[0] + y[0] + root.val;
		return result;
	}
}