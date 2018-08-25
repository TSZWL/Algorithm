package leetcode;

public class Solutionb623 {
	
	public static void main(String args[]){
	}
	//非递归的写法速度更快
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode result = new TreeNode(v);
			result.left = root;
			return result;
		}
		dfs(root, v, d, 2);
		return root;
	}
	private void dfs(TreeNode root, int v, int d, int i) {
		if (root == null) return;
		if (d == i){
			TreeNode x = root.left;
			root.left = new TreeNode(v);
			root.left.left = x;
			x = root.right;
			root.right = new TreeNode(v);
			root.right.right = x;
			return;
		}
		dfs(root.left, v, d, i + 1);
		dfs(root.right, v, d, i + 1);
	}
}