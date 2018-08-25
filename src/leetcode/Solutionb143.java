package leetcode;

import java.util.Stack;

public class Solutionb143 {
	
	public static void main(String args[]){
		Solutionb143 s = new Solutionb143();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		s.reorderList(a);
		while (a != null){
			System.out.println(a.val);
			a = a.next;
		}
	}
	//先使用快慢指针将链表从中间分割成两段，然后后半段就地逆置．之后合并插入到前半段链表，不用Stack
	public void reorderList(ListNode head) {
		int l = 0;
		ListNode begin = head, mid = head;
		while (begin != null){
			begin = begin.next;
			l ++;
		}
		if (l < 3) return;
		begin = head;
		int n = l / 2;
		for (int i = 0; i < n; i ++) mid = mid.next;
		Stack<ListNode> s = new Stack<ListNode>();
		ListNode now = mid;
		for (int i = 0; i < (l - 1) / 2; i ++){
			now = now.next;
			s.add(now);
		}
		for (int i = 0; i < (l - 1) / 2; i ++){
			begin = begin.next;
			head.next = s.pop();
			head = head.next;
			head.next = begin;
			head = head.next;
		}
		if (l % 2 == 0){
			head.next = mid;
			head = head.next;
		}
		head.next = null;
	}
}