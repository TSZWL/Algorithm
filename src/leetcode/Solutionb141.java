package leetcode;

public class Solutionb141 {
	
	public static void main(String args[]){
	}
	//�����ڵ㣬�ֱ���һ����������
	public boolean hasCycle(ListNode head) {
		ListNode x = head, y = head;
		while ((y != null) && (y.next != null)){
			x = x.next;
			y = y.next.next;
			if (x == y) return true;
		}
		return false;
	}
}