package leetcode;

public class Solutionb206 {
	public static void main(String args[]){
	}
	ListNode pre = null;
	public ListNode reverseList(ListNode head) {
		if (head == null) return pre;
		ListNode x = head.next;
		head.next = pre;
		pre = head;
		return reverseList(x);
	}
}