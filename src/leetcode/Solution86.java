package leetcode;

public class Solution86 {
	public static void main(String args[]){
		Solution86 s = new Solution86();
		ListNode x1 = new ListNode(1);
		ListNode x2 = new ListNode(4);
		ListNode x3 = new ListNode(3);
		ListNode x4 = new ListNode(2);
		ListNode x5 = new ListNode(5);
		ListNode x6 = new ListNode(2);
		x1.next = x2;
		x2.next = x3;
		x3.next = x4;
		x4.next = x5;
		x5.next = x6;
		ListNode r = s.partition(x1, 3);
		while (r != null){
			System.out.println(r.val);
			r = r.next;
		}
	}
	public ListNode partition(ListNode head, int x) {
		ListNode result1 = new ListNode(0);
		ListNode result2 = new ListNode(0);
		ListNode l1 = result1, l2 = result2;
		while (head != null){
			if (head.val < x){
				l1.next = head;
				l1 = l1.next;
			} else {
				l2.next = head;
				l2 = l2.next;
			}
			head = head.next;
		}
		l1.next = result2.next;
		l2.next = null;
		return result1.next;
	}
}