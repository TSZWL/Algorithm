package leetcode;

public class Solutionb109 {
	public static void main(String args[]){
	}
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		ListNode now = head;
		int num = 0;
		while (now != null){
			num ++;
			now = now.next;
		}
		TreeNode result = new TreeNode(0);
		make(result, num, head);
		return result;
	}
	private ListNode make(TreeNode tree, int num, ListNode list) {
		if (num == 1){
			tree.val = list.val;
			list = list.next;
			return list;
		}
		int n = num / 2;
		TreeNode left = new TreeNode(0);
		list = make(left, n, list);
		tree.left = left;
		tree.val = list.val;
		list = list.next;
		if (n != num - 1){
			TreeNode right = new TreeNode(0);
			list = make(right, num - 1 - n, list);
			tree.right = right;
		}
		return list;
	}
}