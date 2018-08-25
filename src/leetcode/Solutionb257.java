package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb257 {
	public static void main(String args[]){
	}
	List<String> result = new ArrayList<String>();
	String now = "";
	public List<String> binaryTreePaths(TreeNode root) {
		if (root != null) find(root);
		return result;
	}
	private void find(TreeNode root) {
		now += "->" + root.val;
		if ((root.left == null) && (root.right == null)){
			result.add(now.substring(2));
			now = now.substring(0, now.lastIndexOf("->"));
			return;
		}
		if (root.left != null) find(root.left);
		if (root.right != null) find(root.right);
		now = now.substring(0, now.lastIndexOf("->"));
	}
}