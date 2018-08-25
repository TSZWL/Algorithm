package leetcode;

import java.util.*;

public class Solutionb690 {
	
	public static void main(String args[]){
	}
	public int getImportance(List<Employee> employees, int id) {
		int start = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < employees.size(); i ++) {
			Employee x = employees.get(i);
			if (x.id == id) start = i; 
			map.put(x.id, i);
		}
		return dfs(employees, map, start);
	}
	private int dfs(List<Employee> employees, Map<Integer, Integer> map, int i) {
		Employee x = employees.get(i);
		int result = x.importance;
		List<Integer> y = x.subordinates;
		for (int j : y) result += dfs(employees, map, map.get(j));
		return result;
	}
}