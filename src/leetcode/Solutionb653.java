package leetcode;

public class Solutionb653 {
	
	public static void main(String args[]){
	}
	//只有2个数直接遍历+HashSet即可
	private int n = 0;
	public boolean findTarget(TreeNode root, int k) {
		int[] net = new int[50001];
		dfs(net, root);
		int l = 0, r = n - 1;
		while (l != n - 1){
			while (r > l && net[l] + net[r] >= k) r --;
			if (r != n - 1) r ++;
			if (net[l] + net[r] == k) return true;
			l ++;
		}
		return false;
	}
	private void dfs(int[] net, TreeNode root) {
		if (root.left != null) dfs(net, root.left);
		net[n] = root.val;
		n ++;
		if (root.right != null) dfs(net, root.right);
	}
}