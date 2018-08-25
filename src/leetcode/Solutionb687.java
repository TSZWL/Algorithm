package leetcode;

public class Solutionb687 {
	public static void main(String args[]){
	}
	private int result = 1;
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return result - 1;
	}
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int i = dfs(root.left);
		int j = dfs(root.right);
		int r = 1, tot = 1;
		if (i != 0 && root.left.val == root.val){
			r += i;
			tot += i;
		}
		if (j != 0 && root.right.val == root.val){
			r = Math.max(r, j + 1);
			tot += j;
		}
		result = Math.max(result, tot);
		return r;
	}
}