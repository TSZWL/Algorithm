package leetcode;

public class Solutionb160 {
	
	public static void main(String args[]){
	}
	//计算一下长度。。
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int a = 0, b = 0;
		ListNode x = headA, y = headB;
		while (x != null){
			a ++;
			x = x.next;
		}
		while (y != null){
			b ++;
			y = y.next;
		}
		x = headA;
		y = headB;
		if (a > b){
			for (int i = 0; i < a - b; i ++) x = x.next;
		} else {
			for (int i = 0; i < b - a; i ++) y = y.next;
		}
		while (x != y){
			x = x.next;
			y = y.next;
		}
		return x;
	}
}