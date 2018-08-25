package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
	
	public static void main(String args[]){
		Solution30 s = new Solution30();
		String[] words = {"ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba"};
		List<Integer> r = s.findSubstring("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab", words);
		for (int i : r) System.out.println(i);
	}
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		Map<String,Integer> save = new HashMap<String,Integer>();
		if (words.length == 0) return null;
		for (int i = 0; i < words.length; i ++)
			if (!save.containsKey(words[i]))
				save.put(words[i], 1); 
			else save.put(words[i], save.get(words[i]) + 1);
		Map<String,Integer> map = new HashMap<String,Integer>(save);
		int l = words[0].length();
		for (int i = 0; i < l; i ++){
			int head = i, tail = i;
			while (tail + l <= s.length()){
				String ne = s.substring(tail, l + tail);
				tail += l;
				if (!map.containsKey(ne)){
					head = tail;
					//这么赋值效率比较低？
					map = new HashMap<String,Integer>(save);
					continue;
				}
				map.put(ne, map.get(ne) - 1);
				while (map.get(ne) < 0){
					String xe = s.substring(head, l + head);
					System.out.println(xe+" "+map.get(xe));
					map.put(xe, map.get(xe) + 1);
					head += l;
				}
				System.out.println(head+" "+tail);
				if (tail - head == l * words.length) result.add(head);
			}
			map = new HashMap<String,Integer>(save);
		}
		return result;
	}
}