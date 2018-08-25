package leetcode;

public class Solutionb117 {
	
	public static void main(String args[]){
	}
	//进一步利用一下前面产生的next，先right后left
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		if (root.left == null && root.right == null) return;
		TreeLinkNode x = root.next, y = null;
		while (x != null){
			if (x.left != null){
				y = x.left;
				break;
			}
			if (x.right != null){
				y = x.right;
				break;
			}
			x = x.next;
		}
		if (root.left != null && root.right != null) root.left.next = root.right;
		if (root.right != null){
			root.right.next = y;
		} else {
			root.left.next = y;
		}
		connect(root.right);
		connect(root.left);
	}
}