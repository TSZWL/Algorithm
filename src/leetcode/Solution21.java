package leetcode;

public class Solution21 {
	public static void main(String args[]){
		Solution21 s = new Solution21();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(4);
		ListNode a4 = new ListNode(5);
		a1.next = a2;a2.next = a3;
		ListNode result = s.mergeTwoLists(a4, a1);
		while (result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode x = null, y;
		if (l1.val < l2.val){
			x = l1;
			l1 = l1.next;
		} else {
			x = l2;
			l2 = l2.next;
		}
		y = x;
		while ((l1 != null) && (l2 != null))
			if (l1.val < l2.val){
				y.next = l1;
				y = y.next;
				l1 = l1.next;
			} else {
				y.next = l2;
				y = y.next;
				l2 = l2.next;
			}
		if (l1 == null) y.next = l2;
		if (l2 == null) y.next = l1;
		return x;
	}
}