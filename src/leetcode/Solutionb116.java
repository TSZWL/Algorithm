package leetcode;

public class Solutionb116 {
	
	public static void main(String args[]){
	}
	public void connect(TreeLinkNode root) {
		if (root == null || root.left == null) return;
		root.left.next = root.right;
		if (root.next != null) root.right.next = root.next.left;
		connect(root.left);
		connect(root.right);
	}
}