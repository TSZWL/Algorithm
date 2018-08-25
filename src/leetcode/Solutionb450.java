package leetcode;

public class Solutionb450 {
	
	public static void main(String args[]){
	}
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		if (root.val == key){
			if (root.left != null){
				TreeNode f = root;
				TreeNode d = root.left;
				if (d.right == null){
					root.val = d.val;
					root.left = d.left;
				} else {
					while (d.right != null){
						f = d;
						d = d.right;
					}
					root.val = d.val;
					f.right = d.left;
				}
			} else return root.right;
		} else if (root.val > key){
			root.left = deleteNode(root.left, key);
		} else root.right = deleteNode(root.right, key);
		return root;
	}
}