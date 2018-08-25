package leetcode;

import java.util.*;

public class Solutionb336 {
	
	public static void main(String args[]){
	}
	//不会有重复单词   end不用list而用int形式
	public List<List<Integer>> palindromePairs(String[] words) {
		Tries root = new Tries();
		List<List<Integer>> r = new ArrayList<>();
		for (int i = 0; i < words.length; i ++) {
			Tries now = root;
			char[] x = words[i].toCharArray();
			for (int j = x.length - 1; j >= 0; j --) {
				if (check(x, 0, j)) now.ac.add(i);
				if (now.next[x[j] - 'a'] == null) now.next[x[j] - 'a'] = new Tries();
				now = now.next[x[j] - 'a'];
			}
			now.end = i;
		}
		for (int i = 0; i < words.length; i ++) {
			Set<Integer> set = new HashSet<>();
			Tries now = root;
			char[] x = words[i].toCharArray();
			for (int j = 0; j < x.length; j ++) {
				if (now.end != -1)
					if (check(x, j, x.length - 1))
						if (now.end != i) set.add(now.end);
				now = now.next[x[j] - 'a'];
				if (now == null) break;
			}
			if (now != null) {
				for (int l : now.ac)
					if (l != i) set.add(l);
				if (now.end != -1 && now.end != i) set.add(now.end);
			}
			for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
				r.add(Arrays.asList(i, it.next()));
			}
		}
		return r;
	}
	private boolean check(char[] x, int i, int j) {
		while (i < j) {
			if (x[i] != x[j]) return false;
			i ++;
			j --;
		}
		return true;
	}
}
class Tries {
	Tries[] next;
	List<Integer> ac;
	int end;
	Tries(){
		next = new Tries[26];
		ac = new ArrayList<>();
		end = -1;
	}
}