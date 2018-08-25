package leetcode;

public class Solution19 {
	public static void main(String args[]){
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode x = head;
		if (x == null) return null;
		int num = 0;
		while (x != null){
			num ++;
			x = x.next;
		}
		if (num == n) return head.next;
		x = head;
		for (int i = 0; i < num - n - 1; i ++) x = x.next;
		x.next = x.next.next;
		return head;
	}
}