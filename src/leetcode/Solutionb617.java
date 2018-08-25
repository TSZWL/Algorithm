package leetcode;

public class Solutionb617 {
	
	public static void main(String args[]){
	}
	//蠢了 有一边为空的话根本不用重新建TreeNode。。
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return null;
		if (t1 == null) return t2;
		if (t2 == null) return t1;
		TreeNode r = new TreeNode(t1.val + t2.val);
		r.left = mergeTrees(t1.left, t2.left);
		r.right = mergeTrees(t1.right, t2.right);
		return r;
	}
}