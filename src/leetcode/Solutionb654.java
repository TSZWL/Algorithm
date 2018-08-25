package leetcode;

public class Solutionb654 {
	
	public static void main(String args[]){
	}
	//感觉线段树可以做到O(nlogn)
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return dfs(nums, 0, nums.length - 1);
	}
	private TreeNode dfs(int[] nums, int x, int y) {
		if (x > y) return null;
		if (x == y) return new TreeNode(nums[x]);
		int max = Integer.MIN_VALUE, pos = -1;
		for (int i = x; i <= y; i ++)
			if (max < nums[i]){
				max = nums[i];
				pos = i;
			}
		TreeNode r = new TreeNode(nums[pos]);
		r.left = dfs(nums, x, pos - 1);
		r.right = dfs(nums, pos + 1, y);
		return r;
	}
}