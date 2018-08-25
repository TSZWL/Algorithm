package leetcode;

public class Solution24 {
	
	public static void main(String args[]){
		Solution24 s = new Solution24();
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
		ListNode x = s.swapPairs(a1);
		while (x != null){
			System.out.println(x.val);
			x = x.next;
		}
	}
    public ListNode swapPairs(ListNode head) {
    	int n = 0;
		ListNode x = head;
		ListNode begin = new ListNode(0), now = begin;
		while (x != null){
			x = x.next;
			n ++;
		}
		x = head;
		ListNode y, r = begin, z;
		for (int i = 0; i < n / 2; i ++){
			y = x;
			r = x;
			x = x.next;
			z = x.next;
			x.next = y;
			y = x;
			x = z;
			now.next = y;
			now = r;
		}
		r.next = x;
		return begin.next;
	}
}