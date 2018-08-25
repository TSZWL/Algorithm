package leetcode;

public class Solutionb147 {
	
	public static void main(String args[]){
	}
	public ListNode insertionSortList(ListNode head) {
		if (head == null) return head;
		ListNode end = head;
		ListNode result = new ListNode(0);
		result.next = head;
		while (end.next != null){
			if (end.next.val >= end.val){
				end = end.next;
				continue;
			}
			int l = end.next.val;
			ListNode now = result;
			while (now.next.val < l) now = now.next;
			ListNode next = end.next.next;
			end.next.next = now.next;
			now.next = end.next;
			end.next = next;
		}
		return result.next;
	}
}