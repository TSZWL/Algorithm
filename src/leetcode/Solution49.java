package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Solution49 {
	
	public static void main(String args[]){
		Solution49 s = new Solution49();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> r = s.groupAnagrams(strs);
		for (List<String> a : r){
			for (String b : a) System.out.print(b+" ");
			System.out.println();
		}
	}
	//直接比较O(n^2*m)
	//对每个单词排序+哈希判重
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> m = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i ++){
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String st = new String(c);
			if (!m.containsKey(st)){
				m.put(st, new ArrayList<String>());
			}
			List<String> l = m.get(st);
			l.add(strs[i]);
		}
		for (Iterator<String> it = m.keySet().iterator(); it.hasNext(); ){
			String st = it.next();
			result.add(m.get(st));
		}
		return result;
	}
	/*	boolean[] b = new boolean[strs.length];
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 0; i < strs.length; i ++)
			if (!b[i]){
				List<String> l = new ArrayList<String>();
				b[i] = true;
				l.add(strs[i]);
				int[] c = new int[256];
				for (int j = 0; j < strs[i].length(); j ++) c[strs[i].charAt(j)] ++;
				for (int j = 0; j < strs.length; j ++)
					if (!b[j] && strs[j].length() == strs[i].length()){
						int[] n = Arrays.copyOf(c, c.length);
						boolean d = true;
						for (int k = 0; k < strs[j].length(); k ++)
							if (-- n[strs[j].charAt(k)] < 0){
								d = false;
								break;
							}
						if (d){
							b[j] = true;
							l.add(strs[j]);
						}
					}
				result.add(l);
			}
		return result;
	}*/
}