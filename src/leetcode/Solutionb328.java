package leetcode;

public class Solutionb328 {
	public static void main(String args[]){
	}
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode now = head.next.next, nhead = head.next, h1 = head, h2 = nhead;
		int l = 0;
		while (now != null){
			if (l % 2 == 0){
				h1.next = now;
				h1 = h1.next;
			} else {
				h2.next = now;
				h2 = h2.next;
			}
			now = now.next;
			l ++;
		}
		h1.next = nhead;
		h2.next = null;
		return head;
	}
}