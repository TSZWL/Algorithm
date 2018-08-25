package leetcode;

public class Solution23 {
	
	public static void main(String args[]){
		Solution23 s = new Solution23();
		ListNode[] a = new ListNode[2];
		a[0] = new ListNode(1);
		ListNode a4 = new ListNode(2);
		a[0].next = a4;a4.next = new ListNode(2);
		a[1] = new ListNode(1);
		ListNode a5 = new ListNode(1);
		a[1].next = a5;a5.next = new ListNode(2);
		ListNode x = s.mergeKLists(a);
		while (x != null){
			System.out.println(x.val);
			x = x.next;
		}
	}
	public ListNode mergeKLists(ListNode[] lists) {
		int total = 0;
		int[] f = new int[lists.length + 1];
		int[] b = new int[lists.length + 1];
		for (int i = 0; i < lists.length; i ++)
			if (lists[i] != null){
				total ++;
				int x = total;
				f[x] = lists[i].val;
				b[x] = i;
				while (x > 1)
					if (f[x] < f[x / 2]){
						int n = f[x];f[x] = f[x / 2];f[x / 2] = n;
						n = b[x];b[x] = b[x / 2];b[x / 2] = n;
						x = x / 2;
					} else break;
			}
		ListNode x = new ListNode(0), result = x;
		while (total > 0){
			x.next = lists[b[1]];
			x = x.next;
			lists[b[1]] = lists[b[1]].next;
			if (lists[b[1]] == null){
				f[1] = f[total];
				b[1] = b[total];
				total --;
			} else f[1] = lists[b[1]].val;
			int y = 1;
			while (true)
				if ((y * 2 + 1 <= total) && (f[y * 2 + 1] <= f[y * 2]) && (f[y * 2 + 1] < f[y])){
					int n = f[y];f[y] = f[y * 2 + 1];f[y * 2 + 1] = n;
					n = b[y];b[y] = b[y * 2 + 1];b[y * 2 + 1] = n;
					y = y * 2 + 1;
				} else if((y * 2 <= total) && (f[y * 2] < f[y]) && ((y * 2 + 1 > total) || (f[y * 2] <= f[y * 2 + 1]))){
					int n = f[y];f[y] = f[y * 2];f[y * 2] = n;
					n = b[y];b[y] = b[y * 2];b[y * 2] = n;
					y = y * 2;
				} else break;
		}
		return result.next;
	}
}