package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb113 {
	public static void main(String args[]){
	}
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> now = new ArrayList<Integer>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root != null) find(root, sum, 0);
		return result;
	}
	private void find(TreeNode root, int sum, int nownum) {
		now.add(root.val);
		nownum += root.val;
		if ((root.left == null) && (root.right == null))
			if (nownum == sum) result.add(new ArrayList<Integer>(now));
		if (root.left != null) find(root.left, sum, nownum);
		if (root.right != null) find(root.right, sum, nownum);
		now.remove(now.size() - 1);
		nownum -= root.val;
	}
}