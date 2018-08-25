package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solutionb646 {
	
	public static void main(String args[]){
		Solutionb646 s = new Solutionb646();
		int[][] a = new int[][]{{1, 2}, {2, 3}, {3, 4}};
		System.out.println(s.findLongestChain(a));
	}
	//其实不用栈，直接用变量维护就行
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Stack<int[]> s = new Stack<int[]>();
		int result = 1;
		for (int i = 0; i < pairs.length; i ++){
			if (s.size() != 0 && s.get(0)[1] < pairs[i][0]){
				s.clear();
				result ++;
			}
			while (s.size() != 0 && s.peek()[1] > pairs[i][1]) s.pop();
			s.push(pairs[i]);
		}
		return result;
	}
}