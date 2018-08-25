package leetcode;

public class Solutionb237 {
	
	public static void main(String args[]){
	}
	//交换节点的值
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}