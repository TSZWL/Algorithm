package leetcode;

public class Solutionb142 {
	
	public static void main(String args[]){
	}
	//�����ڵ㣬�ֱ���һ��������
	//��ͷ������λ��s == n������
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