package leetcode;

public class Solutionb114 {
	public static void main(String args[]){
	}
	//实际上就是倒序生成树，last记录生成好的第一个节点
	TreeNode last = null;
	public void flatten(TreeNode root) {
		if (root == null) return;
		flatten(root.right);
		flatten(root.left);
		root.right = last;
		root.left = null;
		last = root;
	}
/*	Stack<TreeNode> s = new Stack<TreeNode>();
	TreeNode last = null;
	public void flatten(TreeNode root) {
		if (root == null) return;
		last = root;
		s.push(root.right);
		if (root.left != null){
			root.right = root.left;
			root.left = null;
			flatten(root.right);
		}
		TreeNode x = s.pop();
		if (x != null){
			last.right = x;
			flatten(x);
		}
	}
*/
}