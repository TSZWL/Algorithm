package leetcode;

public class Solutionb203 {
	
	public static void main(String args[]){
		Solutionb203 s = new Solutionb203();
		s.removeElements(null, 3);
	}
	public ListNode removeElements(ListNode head, int val) {
		ListNode x = new ListNode(0);
		ListNode result = x;
		while (head != null){
			while ((head != null) && (head.val == val)) head = head.next;
			x.next = head;
			x = head;
			if (head != null) head = head.next;
		}
		return result.next;
	}
}