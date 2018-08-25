package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Solutionb472 {
	
	public static void main(String args[]){
		Solutionb472 s = new Solutionb472();
		String[] a = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		List<String> r = s.findAllConcatenatedWordsInADict(a);
		for (String st : r) System.out.println(st);
	}
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Set<String> set = new HashSet<String>();
		List<String> result = new ArrayList<String>();
		Arrays.sort(words, new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		for (int i = 0; i < words.length; i ++)
			if (words[i].length() > 0){
				if (check(words[i], set)) result.add(words[i]);
				set.add(words[i]);
			}
		return result;
	}
	private boolean check(String s, Set<String> set) {
		boolean[] b = new boolean[s.length() + 1];
		b[0] = true;
		for (int i = 1; i <= s.length(); i ++)
			for (int j = 0; j < i; j ++)
				if (b[j] && set.contains(s.substring(j, i))){
					b[i] = true;
					break;
				}
		return b[s.length()];
	}
}