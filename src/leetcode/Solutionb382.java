package leetcode;

import java.util.*;

class Solution_3 {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
	//记录一个size然后随机也挺好的。
	ListNode head;
	Random r;
    public Solution_3(ListNode head) {
        this.head = head;
        r = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int result = 0, l = 0;
        ListNode now = head;
        while (now != null) {
        	if (r.nextInt(++ l) == 0) result = now.val;
        	now = now.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */