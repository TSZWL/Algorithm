package leetcode;

public class Solution25 {
	
	public static void main(String args[]){
		Solution25 s = new Solution25();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);
		ListNode a8 = new ListNode(8);
		ListNode a9 = new ListNode(9);
		ListNode a10 = new ListNode(10);
		a1.next = a2;a2.next = a3;a3.next = a4;a4.next = a5;
		a5.next = a6;a6.next = a7;a7.next = a8;a8.next = a9;a9.next = a10;
		ListNode x = s.reverseKGroup(a1, 11);
		while (x != null){
			System.out.println(x.val);
			x = x.next;
		}
	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	int n = 0;
		ListNode x = head;
		ListNode begin = new ListNode(0), now = begin;
		while (x != null){
			x = x.next;
			n ++;
		}
		x = head;
		ListNode y = x, r = begin, z = x;
		for (int i = 0; i < n / k; i ++){
			y = x;
			r = x;
			z = x.next;
			x = x.next;
			for (int j = 1; j < k; j ++){
				z = x.next;
				x.next = y;
				y = x;
				x = z;
			}
			now.next = y;
			now = r;
		}
		r.next = x;
		return begin.next;
	}
}