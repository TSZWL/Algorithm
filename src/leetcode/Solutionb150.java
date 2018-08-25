package leetcode;

import java.util.Stack;

public class Solutionb150 {
	
	public static void main(String args[]){
		Solutionb150 s = new Solutionb150();
		String[] a = {"4", "13", "5", "/", "+"};
		System.out.println(s.evalRPN(a));
	}
	Stack<Integer> s = new Stack<Integer>();
	public int evalRPN(String[] tokens) {
		for (int i = 0; i < tokens.length; i ++)
			if (tokens[i].equals("+")){
				s.push(s.pop() + s.pop());
			} else if (tokens[i].equals("-")){
				s.push(-s.pop() + s.pop());
			} else if (tokens[i].equals("*")){
				s.push(s.pop() * s.pop());
			} else if (tokens[i].equals("/")){
				int x = s.pop();
				s.push(s.pop() / x);
			} else s.push(Integer.parseInt(tokens[i]));
		return s.peek();
	}
}