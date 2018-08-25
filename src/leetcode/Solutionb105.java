package leetcode;


public class Solutionb105 {
	public static void main(String args[]){
	}
	int[] p1, p2;
	int val = -1;
	//使用hashmap而不是循环来get index
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		p1 = preorder;
		p2 = inorder;
		if (p1.length == 0) return null;
		return build(0, p1.length);
	}
	private TreeNode build(int p, int q) {
		if (p == q) return null;
		val ++;
		TreeNode now = new TreeNode(p1[val]);
		for (int i = p; i < q; i ++)
			if (p2[i] == p1[val]){
				now.left = build(p, i);
				now.right = build(i + 1, q);
				break;
			}
		return now;
	}
}