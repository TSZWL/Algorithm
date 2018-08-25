package leetcode;

public class Solution83 {
	public static void main(String args[]){
	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		ListNode now = head;
		while (now.next != null)
			if (now.val == now.next.val) now.next = now.next.next;
			else now = now.next;
		return head;
	}
}