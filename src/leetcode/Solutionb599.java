package leetcode;

import java.util.*;

public class Solutionb599 {
	
	public static void main(String args[]){
	}
	public String[] findRestaurant(String[] list1, String[] list2) {
		List<String> r = new ArrayList<>();
		int index = Integer.MAX_VALUE;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i ++) map.put(list1[i], i);
		for (int i = 0; i < list2.length; i ++)
			if (map.containsKey(list2[i])){
				int l = map.get(list2[i]) + i;
				if (l <= index){
					if (l < index) r = new ArrayList<>();
					index = l;
					r.add(list2[i]);
				}
			}
		String[] result = new String[r.size()];
		for (int i = 0; i < r.size(); i ++) result[i] = r.get(i);
		return result;
	}
}