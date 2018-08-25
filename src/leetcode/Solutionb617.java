package leetcode;

public class Solutionb617 {
	
	public static void main(String args[]){
	}
	//���� ��һ��Ϊ�յĻ������������½�TreeNode����
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