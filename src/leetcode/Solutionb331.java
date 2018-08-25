package leetcode;

import java.util.*;

public class Solutionb331 {
	
	public static void main(String args[]){
		Solutionb331 s = new Solutionb331();
		System.out.println(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
	public boolean isValidSerialization(String preorder) {
		String[] a = preorder.split(",");
		Stack<String> s = new Stack<String>();
		try {
			for (int i = 0; i < a.length; i ++){
				if (a[i].equals("#"))
					while (!s.isEmpty() && s.peek().equals("#")){
						s.pop();
						s.pop();
					}
				s.push(a[i]);
			}
		} catch (Exception e) {
			return false;
		}
		if (s.size() != 1 || !s.peek().equals("#")) return false;
		return true;
	}
}
/*
更简单快速的方法
for(String node : nodes){
    if(-- diff < 0) return false;
    if(!node.equals("#")) diff += 2;
}
*/