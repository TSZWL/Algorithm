package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb515 {
	public static void main(String args[]){
	}
	int maxdepth = 0;
	int[] r = new int[10001];
	public List<Integer> largestValues(TreeNode root) {
		for (int i = 0; i < 10001; i ++) r[i] = Integer.MIN_VALUE;
		List<Integer> result = new ArrayList<Integer>();
		if (root != null) find(root, 1); else return result;
		for (int i = 1; i <= maxdepth; i ++) result.add(r[i]);
		return result;
	}
	private void find(TreeNode root, int deep) {
		if (deep > maxdepth) maxdepth = deep;
		if (root.val > r[deep]) r[deep] = root.val;
		if (root.left != null) find(root.left, deep + 1);
		if (root.right != null) find(root.right, deep + 1);
	}
}