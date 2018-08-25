package leetcode;

import java.util.*;

public class Solutionb648 {
	
	public static void main(String args[]){
		Solutionb648 s = new Solutionb648();
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		System.out.println(s.replaceWords(dict, "the cattle was rattled by the battery"));
	}
	//StringBuilder.append的速度远远快于String += ...
	class DictTree{
		DictTree[] next = new DictTree[26];
		String word = null;
	}
	public String replaceWords(List<String> dict, String sentence) {
		DictTree root = new DictTree();
		for (String s : dict){
			DictTree x = root;
			for (char c : s.toCharArray()){
				if (x.next[c - 'a'] == null) x.next[c - 'a'] = new DictTree();
				x = x.next[c - 'a'];
			}
			x.word = s;
		}
		String[] r = sentence.split(" ");
		for (int i = 0; i < r.length; i ++){
			DictTree x = root;
			for (char c : r[i].toCharArray()){
				if (x.word != null) break;
				if (x.next[c - 'a'] == null) break;
				x = x.next[c - 'a'];
			}
			if (x.word != null) r[i] = x.word;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r.length; i ++) sb.append(" ").append(r[i]);
		return sb.substring(1).toString();
	}
}