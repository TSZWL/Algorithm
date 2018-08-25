package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {
	public static void main(String args[]){
	}
	public List<TreeNode> generateTrees(int n) {
		return find(n, 1);
	}
	private List<TreeNode> find(int n, int num) {
		if (n == 0) return new ArrayList<TreeNode>();
		List<TreeNode> result = new ArrayList<TreeNode>();
		for (int i = 0; i < n; i ++){
			List<TreeNode> x = find(i, num);
			if (x.size() == 0) x.add(null);
			List<TreeNode> y = find(n - i - 1, num + i + 1);
			if (y.size() == 0) y.add(null);
			for (TreeNode a : x)
				for (TreeNode b : y){
					TreeNode root = new TreeNode(num + i);
					root.left = a;
					root.right = b;
					result.add(root);
				}
		}
		return result;
	}
}