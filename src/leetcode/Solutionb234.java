package leetcode;

public class Solutionb234 {
	
	public static void main(String args[]){
	}
	//只有翻转才能同步比较
	public boolean isPalindrome(ListNode head) {
		ListNode now = head;
		int num = 0;
		while (now != null){
			now = now.next;
			num ++;
		}
		if (num < 2) return true;
		now = head;
		for (int i = 0; i < (num + 1) / 2; i ++) now = now.next;
		ListNode a = now.next;
		while (a != null){
			ListNode b = a.next;
			a.next = now;
			now = a;
			a = b;
		}
		a = head;
		for (int i = 0; i < num / 2; i ++){
			if (a.val != now.val) return false;
			a = a.next;
			now = now.next;
		}
		return true;
	}
}