package leetcode;

public class Solutionb538 {
	
	public static void main(String args[]){
	}
	int tot = 0;
	public TreeNode convertBST(TreeNode root) {
		if (root == null) return root;
		convertBST(root.right);
		root.val += tot;
		tot = root.val;
		convertBST(root.left);
		return root;
	}
}