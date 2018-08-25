package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solutionb106 {
	public static void main(String args[]){
	}
	int[] p1, p2;
	int val;
	Map<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		p1 = postorder;
		p2 = inorder;
		val = p1.length;
		if (p1.length == 0) return null;
		for (int i = 0; i < p1.length; i ++) map.put(p2[i], i);
		return build(0, p1.length);
	}
	private TreeNode build(int p, int q) {
		if (p == q) return null;
		val --;
		TreeNode now = new TreeNode(p1[val]);
		int i = map.get(p1[val]);
		now.right = build(i + 1, q);
		now.left = build(p, i);
		return now;
	}
}