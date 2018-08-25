package leetcode;

import java.util.*;

public class Solutionb138 {
	
	public static void main(String args[]){
	}
	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		RandomListNode x = new RandomListNode(head.label);
		map.put(head, x);
		x.next = copyRandomList(head.next);
		x.random = map.get(head.random);
		return x;
	}
/*扩展成 两倍(copy 连接好之后再取回来
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode iter = head, next;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;

			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;

			iter = next;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		RandomListNode pseudoHead = new RandomListNode(0);
		RandomListNode copy, copyIter = pseudoHead;

		while (iter != null) {
			next = iter.next.next;

			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;

			// restore the original list
			iter.next = next;

			iter = next;
		}

		return pseudoHead.next;
	}
*/
}