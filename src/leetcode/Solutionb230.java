package leetcode;

public class Solutionb230 {
	public static void main(String args[]){
	}
	int result = 0;
	public int kthSmallest(TreeNode root, int k) {
		find(root, k); 
		return result;
	}
	private int find(TreeNode root, int k) {
		int r = k;
		if (root.left != null) k -= find(root.left, k);
		if (k <= 0) return Integer.MAX_VALUE;
		k --;
		if (k == 0){
			result = root.val;
			return Integer.MAX_VALUE;
		}
		if (root.right != null) k -= find(root.right, k);
		if (k <= 0) return Integer.MAX_VALUE;
		return r - k;
	}
}