package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb401 {
	
	public static void main(String args[]){
		Solutionb401 s = new Solutionb401();
		List<String> r = s.readBinaryWatch(8);
		for (String c : r) System.out.println(c);
	}
	List<String> result = new ArrayList<String>();
	int[] n = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
	public List<String> readBinaryWatch(int num) {
		dfs(num, 0, 0, 0);
		return result;
	}
	private void dfs(int num, int j, int m, int s){
		if (m > 11) return;
		if (s > 59) return;
		if (10 - j < num) return;
		if (num == 0){
			String st = m + ":";
			if (s < 10) st += "0";
			st += s;
			result.add(st);
		}
		for (int i = j; i < 10; i ++)
			if (i < 4)
				dfs(num - 1, i + 1, m + n[i], s); 
			else dfs(num - 1, i + 1, m, s + n[i]);
	}
}