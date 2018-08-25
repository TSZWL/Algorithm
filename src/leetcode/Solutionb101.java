package leetcode;

public class Solutionb101 {
	
	public static void main(String args[]){
	}
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSameTree(root.left, root.right);
	}
	private boolean isSameTree(TreeNode p, TreeNode q) {
		if ((p == null) && (q == null)) return true;
		if ((p == null) || (q == null)) return false;
		if (p.val != q.val) return false;
		return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
	}
}