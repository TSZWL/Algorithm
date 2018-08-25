package leetcode;

public class Solution92 {
	public static void main(String args[]){
	}
	ListNode pre = null, next = null;
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode now = result;
		for (int i = 1; i < m; i ++) now = now.next;
		ListNode three = now.next;
		now.next = reverseList(now.next, n - m);
		three.next = next;
		return result.next;
	}
	
	public ListNode reverseList(ListNode head, int num) {
		if (num < 0){
			next = head;
			return pre;
		}
		ListNode x = head.next;
		head.next = pre;
		pre = head;
		return reverseList(x, num - 1);
	}
}