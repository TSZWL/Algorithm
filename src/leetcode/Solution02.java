package leetcode;

public class Solution02 {
	public static void main(String args[]){
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l = l1;
		int n = 0;
		while (true){
			l.val += n / 10;
			n = l.val + l2.val;
			l.val = n % 10;
			if ((l.next == null) && (l2.next == null)){
				if (n > 9) l.next = new ListNode(1);
				break;
			}
			if (l.next == null) l.next = new ListNode(0);
			if (l2.next == null) l2.next = new ListNode(0);
			l = l.next;
			l2 = l2.next;
		}
		return l1;
	}
}