package leetcode;

import java.util.*;

public class Solutionb144 {
	
	public static void main(String args[]){
	}
	List<Integer> result =new ArrayList<Integer>();
	Stack<TreeNode> s = new Stack<TreeNode>();
	public List<Integer> preorderTraversal(TreeNode root) {
		while (root != null){
			result.add(root.val);
			s.push(root);
			root = root.left;
		}
		while (!s.empty()){
			root = s.pop().right;
			while (root != null){
				result.add(root.val);
				s.push(root);
				root = root.left;
			}
		}
		return result;
	}
/*这么写更简明
    Stack<TreeNode> s = new Stack<TreeNode>();
    s.push(root);
    while(!s.isEmpty()){
        TreeNode cur = s.pop();
        pre.add(cur.val);
        if(cur.right != null) s.push(cur.right);
        if(cur.left != null) s.push(cur.left);
    }
 */
}