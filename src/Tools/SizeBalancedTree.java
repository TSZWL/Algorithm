package Tools;

public class SizeBalancedTree {
	
	int rotate = 0, maint = 0;
	Node root = new Node();
	
	private class Node {
		int size, val;
		Node left, right;
		Node() {
			size = 0;
			left = this;
			right = this;
		}
		Node(int val) {
			size = 1;
			this.val = val;
			left = new Node();
			right = new Node();
		}
	}
	
	private Node right_rotate(Node root) {
		rotate ++;
		Node k = root.left;
		root.left = k.right;
		k.right = root;
		k.size = root.size;
		root.size = root.left.size + root.right.size + 1;
		return k;
	}
	
	private Node left_rotate(Node root) {
		rotate ++;
		Node k = root.right;
		root.right = k.left;
		k.left = root;
		k.size = root.size;
		root.size = root.left.size + root.right.size + 1;
		return k;
	}
	
	private Node maintain(Node root, boolean flag) {
		maint ++;
		if (!flag)
			if (root.left.left.size > root.right.size) root = right_rotate(root);
			else if (root.left.right.size > root.right.size) {
				root.left = left_rotate(root.left);
				root = right_rotate(root);
			} else return root;
		else if (root.right.right.size > root.left.size) root = left_rotate(root);
		else if (root.right.left.size > root.left.size) {
			root.right = right_rotate(root.right);
			root = left_rotate(root);
		} else return root;
		root.left = maintain(root.left, false);
		root.right = maintain(root.right, true);
		root = maintain(root, true);
		root = maintain(root, false);
		return root;
	}
	
	public void insert(int val) {
		root = insert(root, val);
	}
	
	private Node insert(Node root, int val) {
		if (root.size == 0) return new Node(val);
		else {
			root.size ++;
			if (val < root.val) root.left = insert(root.left, val);
			else root.right = insert(root.right, val);
			root = maintain(root, val >= root.val ? true : false);
			return root;
		}
	}
	
	public int delete(int val) {
		return delete(root, val);
	}
	
	private int delete(Node root, int val) {
		root.size --;
		if (val == root.val || val < root.val && root.left.size == 0 || val > root.val && root.right.size == 0) {
			int result = root.val;
			if (root.left.size == 0 || root.right.size == 0) root = root.left.size == 0 ? root.right : root.left;
			else root.val = delete(root.left, root.val + 1);
			return result;
		} else if (val < root.val) return delete(root.left, val);
		else return delete(root.right, val);
	}
	
	public boolean find(int val) {
		return find(root, val);
	}
	
	private boolean find(Node root, int val) {
		if (root.size == 0) return false;
		if (val < root.val) return find(root.left, val);
		else return (root.val == val) || find(root.right, val);
	}
	
	public int rank(int val) {
		return rank(root, val);
	}
	
	private int rank(Node root, int val) {
		if (root.size == 0) return 1;
		if (val <= root.val) return rank(root.left, val);
		else return root.left.size + 1 + rank(root.right, val);
	}
	
	public int select(int k) {
		return select(root, k);
	}
	
	private int select(Node root, int k) {
		if (k == root.left.size + 1) return root.val;
		if (k <= root.left.size) return select(root.left, k);
		else return select(root.right, k - 1 - root.left.size);
	}
	
	public int pred(int val) {
		return pred(root, val);
	}
	
	private int pred(Node root, int val) {
		if (root.size == 0) return val;
		if (val <= root.val) return pred(root.left, val);
		else {
			int result = pred(root.right, val);
			if (val == result) result = root.val;
			return result;
		}
	}
	
	public int succ(int val) {
		return succ(root, val);
	}
	
	private int succ(Node root, int val) {
		if (root.size == 0) return val;
		if (val >= root.val) return succ(root.right, val);
		else {
			int result = succ(root.left, val);
			if (val == result) result = root.val;
			return result;
		}
	}
	
	public static void main(String[] args) {
		SizeBalancedTree sbt = new SizeBalancedTree();
		for (int i = 1; i <= 1000000; i ++) {
			sbt.insert((int) Math.floor(Math.random() * 500000000));
		}
		System.out.println(sbt.rotate + " " + sbt.maint);
	}
}
