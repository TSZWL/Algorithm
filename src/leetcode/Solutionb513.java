package leetcode;

public class Solutionb513 {
	
	public static void main(String args[]){
	}
	private int result, h = -1;
	public int findBottomLeftValue(TreeNode root) {
		dfs(root, 0);
		return result;
	}
	private void dfs(TreeNode root, int i) {
		if (i > h){
			h = i;
			result = root.val;
		}
		if (root.left != null) dfs(root.left, i + 1);
		if (root.right != null) dfs(root.right, i + 1);
	}
}