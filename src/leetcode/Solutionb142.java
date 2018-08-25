package leetcode;

public class Solutionb142 {
	
	public static void main(String args[]){
	}
	//快慢节点，分别走一步和两步
	//开头到相遇位置s == n倍环长
	public ListNode detectCycle(ListNode head) {
		ListNode x = head, y = head, z = head;
		while ((y != null) && (y.next != null)){
			x = x.next;
			y = y.next.next;
			if (x == y) break;
		}
		if ((y == null) || (y.next == null)) return null;
		while (x != z){
			x = x.next;
			z = z.next;
		}
		return x;
	}
}