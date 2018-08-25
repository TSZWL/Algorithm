package leetcode;

import java.util.*;

public class Solutionb445 {
	public static void main(String args[]){
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();
		while (l1 != null){
			a.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null){
			b.push(l2.val);
			l2 = l2.next;
		}
		int next = 0;
		ListNode result = null;
		while (!a.empty() || !b.empty()){
			int l = next;
			if (!a.empty()) l += a.pop();
			if (!b.empty()) l += b.pop();
			next = l / 10;
			l = l % 10;
			ListNode n = new ListNode(l);
			n.next = result;
			result = n;
		}
		if (next != 0){
			ListNode n = new ListNode(next);
			n.next = result;
			result = n;
		}
		return result;
	}
}