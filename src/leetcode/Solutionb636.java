package leetcode;

import java.util.*;

public class Solutionb636 {
	
	public static void main(String args[]){
		Solutionb636 s = new Solutionb636();
		List<String> a = new ArrayList<String>();
		a.add("0:start:0");
		a.add("1:start:2");
		a.add("1:end:5");
		a.add("0:end:6");
		int[] r = s.exclusiveTime(2, a);
		for (int i = 0; i < 2; i ++) System.out.print(r[i] + " ");
		System.out.println();
	}
	Stack<Integer> s = new Stack<Integer>();
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		int last = 0;
		for (String st : logs){
			String[] a = st.split(":");
			int l = Integer.parseInt(a[2]);
			if (a[1].startsWith("s")){
				if (!s.empty()) result[s.peek()] += l - last - 1;
				last = l - 1;
				s.push(Integer.parseInt(a[0]));
			} else {
				result[s.pop()] += l - last;
				last = l;
			}
		}
		return result;
	}
}