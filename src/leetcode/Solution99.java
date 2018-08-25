package leetcode;

public class Solution99 {
	public static void main(String args[]){
	}
	int tot = 0;
	TreeNode first = null, second = null, last = null;
	public void recoverTree(TreeNode root) {
		dfs(root);
		int val = first.val;
		first.val = second.val;
		second.val = val;
	}
	private void dfs(TreeNode root) {
		if (root.left != null) dfs(root.left);
		if (last != null && last.val > root.val)
			if (tot == 0){
				first = last;
				second = root;
				tot ++;
			} else {
				second = root;
			}
		last = root;
		if (root.right != null) dfs(root.right);
	}
}