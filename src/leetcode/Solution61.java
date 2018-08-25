package leetcode;

public class Solution61 {
	
	public static void main(String args[]){
	}
	public ListNode rotateRight(ListNode head, int k) {
		int l = 0;
		ListNode begin = head;
		while (begin != null){
			begin = begin.next;
			l ++;
		}
		if (l == 0) return head;
		k = k % l;
		if (k == 0) return head;
		l = l - k;
		begin = head;
		for (int i = 1; i < l; i ++) begin = begin.next;
		ListNode now = begin;
		begin = begin.next;
		now.next = null;
		now = begin;
		for (int i = 1; i < k; i ++) begin = begin.next;
		begin.next = head;
		return now;
	}
}