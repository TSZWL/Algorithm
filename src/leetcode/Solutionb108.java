package leetcode;

public class Solutionb108 {
	
	public static void main(String args[]){
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		return makeTree(nums, 0, nums.length);
	}
	private TreeNode makeTree(int[] nums, int s, int n) {
		if (n == 0) return null;
		if (n == 1) return new TreeNode(nums[s]);
		int l = n / 2;
		TreeNode result = new TreeNode(nums[s + l]);
		result.left = makeTree(nums, s, l);
		result.right = makeTree(nums, s + l + 1, n - 1 - l);
		return result;
	}
}