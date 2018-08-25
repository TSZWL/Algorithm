package leetcode;

import java.util.*;

public class Solutionb187 {
	
	public static void main(String args[]){
	}
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		if (s.length() < 11) return result;
		char[] c = s.toCharArray();
		int[] x = new int[200];
		x['A'] = 1;
		x['C'] = 2;
		x['G'] = 3;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = (1 << 20) - 1, now = 0;
		for (int i = 0; i < 9; i ++) now = (now << 2) + x[c[i]];
		for (int i = 9; i < c.length; i ++){
			now = ((now << 2) + x[c[i]]) & max;
			if (!map.containsKey(now)) map.put(now, 1);
			else map.put(now, map.get(now) + 1);
			if (map.get(now) == 2) result.add(String.valueOf(c, i - 9, 10));
		}
		return result;
	}
}