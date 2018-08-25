package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solutionb437 {
	public static void main(String args[]){
	}
	Map<Integer, Integer> now = new HashMap<Integer, Integer>();
	public int pathSum(TreeNode root, int sum) {
		now.put(0, 1);
		if (root != null) return find(root, sum, 0);
		return 0;
	}
	private int find(TreeNode root, int sum, int nownum) {
		int result = 0;
		nownum += root.val;
		Integer x = now.get(nownum - sum);
		if (x == null) x = 0;
		result += x;
		x = now.get(nownum);
		if (x == null) x = 0;
		now.put(nownum, x + 1);
		if (root.left != null) result += find(root.left, sum, nownum);
		if (root.right != null) result += find(root.right, sum, nownum);
		x = now.get(nownum);
		if (x == 1) now.remove(nownum);
			else now.put(nownum, x - 1);
		nownum -= root.val;
		return result;
	}
}