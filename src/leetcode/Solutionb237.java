package leetcode;

public class Solutionb237 {
	
	public static void main(String args[]){
	}
	//�����ڵ��ֵ
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}