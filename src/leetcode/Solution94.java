package leetcode;

import java.util.*;

public class Solution94 {
	public static void main(String args[]){
	}
	List<Integer> result =new ArrayList<Integer>();
	Stack<TreeNode> s = new Stack<TreeNode>();
	public List<Integer> inorderTraversal(TreeNode root) {
		while (root != null){
			s.push(root);
			root = root.left;
		}
		while (!s.empty()){
			TreeNode x = s.pop();
			result.add(x.val);
			root = x.right;
			while (root != null){
				s.push(root);
				root = root.left;
			}
		}
		return result;
	}
}