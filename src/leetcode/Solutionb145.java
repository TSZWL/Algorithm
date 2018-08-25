package leetcode;

import java.util.*;

public class Solutionb145 {
	
	public static void main(String args[]){
	}
	//�ǵݹ�ĺ������
	List<Integer> result =new ArrayList<Integer>();
	Stack<TreeNode> s = new Stack<TreeNode>();
	public List<Integer> postorderTraversal(TreeNode root) {
		while (root != null){
			result.add(0, root.val);
			s.push(root);
			root = root.right;
		}
		while (!s.empty()){
			root = s.pop().left;
			while (root != null){
				result.add(0, root.val);
				s.push(root);
				root = root.right;
			}
		}
		return result;
	}
/*��ôд������
    Stack<TreeNode> s = new Stack<TreeNode>();
    s.push(root);
    while(!s.isEmpty()){
        TreeNode cur = s.pop();
        pre.add(0, cur.val);
        if(cur.left != null) s.push(cur.left);
        if(cur.right != null) s.push(cur.right);
    }
 */
}