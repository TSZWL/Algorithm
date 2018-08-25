package leetcode;

public class Solution82 {
	public static void main(String args[]){
	}
	public ListNode deleteDuplicates(ListNode head) {
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode now = result;
		while (now.next != null && now.next.next != null){
			if (now.next.val != now.next.next.val){
				now = now.next;
				continue;
			}
			ListNode n = now.next;
			while (n.next != null && n.val == n.next.val) n = n.next;
			now.next = n.next;
		}
		return result.next;
	}
}