package leetcode;

public class Solution98 {
	public static void main(String args[]){
	}
	boolean result = true;
	public boolean isValidBST(TreeNode root) {
		if (root != null) find(root); 
		return result;
	}
	private int[] find(TreeNode root) {
		int[] r = new int[]{root.val, root.val};
		if (root.left != null){
			int[] a = find(root.left);
			if ((a[1] >= r[0]) || (!result)){
				result = false;
				return r;
			}
			r[0] = a[0];
		}
		if (root.right != null){
			int[] a = find(root.right);
			if ((a[0] <= r[1]) || (!result)){
				result = false;
				return r;
			}
			r[1] = a[1];
		}
		return r;
	}
}