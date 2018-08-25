package leetcode;

public class Solutionb226 {
	
	public static void main(String args[]){
	}
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode result = new TreeNode(root.val);
		result.left = invertTree(root.right);
		result.right = invertTree(root.left);
		return result;
	}
}