package leetcode;

public class Solutionb112 {
	public static void main(String args[]){
	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root != null) return find(root, sum, 0);
		return false;
	}
	private boolean find(TreeNode root, int sum, int nownum) {
		boolean b = false;
		nownum += root.val;
		if ((root.left == null) && (root.right == null))
			if (nownum == sum) return true;
		if (root.left != null) b = find(root.left, sum, nownum);
		if (b) return true;
		if (root.right != null) b = find(root.right, sum, nownum);
		if (b) return true;
		nownum -= root.val;
		return false;
	}
}