package leetcode;

public class Solutionb148 {
	
	public static void main(String args[]){
	}
	public ListNode sortList(ListNode head) {
		ListNode fast = head, slow = head;
		if (fast == null || fast.next == null) return head;
		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		fast = sortList(fast);
		head = sortList(head);
		ListNode start = new ListNode(0);
		slow = start;
		while (fast != null && head != null)
			if (fast.val < head.val){
				start.next = fast;
				start = fast;
				fast = fast.next;
			} else {
				start.next = head;
				start = head;
				head = head.next;
			}
		while (fast != null){
			start.next = fast;
			start = fast;
			fast = fast.next;
		}
		while (head != null){
			start.next = head;
			start = head;
			head = head.next;
		}
		return slow.next;
	}
}