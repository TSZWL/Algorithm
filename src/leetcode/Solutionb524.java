package leetcode;

import java.util.*;

public class Solutionb524 {
	public static void main(String args[]){
		Solutionb524 s = new Solutionb524();
		String a = "...";
		List<String> r = new ArrayList<String>();
		r.add("jpthi udqzzeugzwwsngebdeai");
		r.add("nbmxgkduynigvzuyblwjepn");
		System.out.println(s.findLongestWord(a, r));
	}
	public String findLongestWord(String s, List<String> d) {
		ListNode[] x = new ListNode[26];
		char[] c = s.toCharArray();
		for (int i = c.length - 1; i >= 0; i --){
			int j = c[i] - 'a';
			if (x[j] == null){
				x[j] = new ListNode(i);
			} else {
				ListNode now = new ListNode(i);
				now.next = x[j];
				x[j] = now;
			}
		}
		Collections.sort(d, new Comparator<String>(){
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) return o1.compareTo(o2);
				return o2.length() - o1.length();
			}
		});
		for (String st : d){
			c = st.toCharArray();
			ListNode[] n = new ListNode[26];
			for (int j = 0; j < 26; j ++) n[j] = x[j];
			int pos = 0;
			boolean b = true;
			for (int i = 0; i < c.length; i ++){
				int j = c[i] - 'a';
				while (n[j] != null && n[j].val < pos) n[j] = n[j].next;
				if (n[j] == null){
					b = false;
					break;
				} else {
					pos = n[j].val;
					n[j] = n[j].next;
				}
			}
			if (!b) continue;
			return st;
		}
		return "";
	}
}