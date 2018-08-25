package leetcode;

import java.util.*;

public class Solutionb332 {
	
	public static void main(String args[]){
		Solutionb332 s = new Solutionb332();
		String[][] a = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
		List<String> r = s.findItinerary(a);
		for (String i : r) System.out.println(i);
	}
	//欧拉路 字典序最小 排序+dfs
	public List<String> findItinerary(String[][] tickets) {
		Map<String, Queue<String>> map = new HashMap<String, Queue<String>>();
		for (int i = 0; i < tickets.length; i ++){
			if (!map.containsKey(tickets[i][0])){
				Queue<String> l = new PriorityQueue<String>();
				map.put(tickets[i][0], l);
			}
			map.get(tickets[i][0]).add(tickets[i][1]);
		}
		List<String> result = new ArrayList<String>();
		dfs(result, map, "JFK");
		return result;
	}
	private void dfs(List<String> result, Map<String, Queue<String>> map, String s) {
		Queue<String> q = map.get(s);
		while (q != null && q.size() != 0){
			String next = q.poll();
			dfs(result, map, next);
		}
		result.add(0, s);
	}
}