package leetcode;

import java.util.*;

public class Solution68 {
	public static void main(String args[]){
		Solution68 s = new Solution68();
		String[] a = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		List<String> r = s.fullJustify(a, 16);
		for (String st : r) System.out.println(st);
	}
	public List<String> fullJustify(String[] words, int maxWidth) {
		int i = 0;
		List<String> result = new ArrayList<String>();
		while (i < words.length){
			int l = words[i].length();
			int now = i ++;
			while (i < words.length && l + 1 + words[i].length() <= maxWidth){
				l += 1 + words[i].length();
				i ++;
			}
			if (i == now + 1){
				String r = words[now];
				for (int k = 0; k < maxWidth - l; k ++) r += " ";
				result.add(r);
				continue;
			}
			if (i == words.length){
				String r = words[now];
				for (int j = now + 1; j < i; j ++) r += " " + words[j];
				for (int j = 0; j < maxWidth - l; j ++) r += " ";
				result.add(r);
				return result;
			}
			int a = (maxWidth - l) / (i - now - 1);
			int b = (maxWidth - l) % (i - now - 1);
			String r = words[now];
			for (int j = now + 1; j < i; j ++){
				if (j - now - 1 < b) r += " ";
				for (int k = -1; k < a; k ++) r += " ";
				r += words[j];
			}
			result.add(r);
		}
		return result;
	}
}