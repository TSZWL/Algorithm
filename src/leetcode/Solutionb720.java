package leetcode;

import java.util.*;

public class Solutionb720 {
	
	public static void main(String args[]){
	}
	//用字典树更快，毕竟不用频繁的String操作
	//不用的话直接排序也就好了么。。(字典序
	public String longestWord(String[] words) {
		String r = "";
		Set<String> set = new HashSet<String>();
		Arrays.sort(words);
		for (String s : words) {
			String x = s.substring(0, s.length() - 1);
			if (x.length() == 0 || set.contains(x)) {
				set.add(s);
				if (s.length() > r.length()) r = s;
			}
		}
		return r;
	}
}