package leetcode;

import java.util.*;

public class Solutionb224 {
	
	public static void main(String args[]){
		Solutionb224 s = new Solutionb224();
		System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	Stack<Integer> num = new Stack<Integer>();
	Stack<Integer> js = new Stack<Integer>();
	public int calculate(String s) {
		s = s.replace(" ", "");
		char[] c = s.toCharArray();
		int now = 0;
		num.push(0);
		js.push(1);
		for (int i = 0; i < c.length; i ++)
			if (c[i] == '('){
				num.push(0);
				js.push(1);
			} else if (c[i] == ')') {
				now = num.pop() + now * js.pop();
			} else if (c[i] == '+') {
				num.push(num.pop() + now * js.pop());
				now = 0;
				js.push(1);
			} else if (c[i] == '-') {
				num.push(num.pop() + now * js.pop());
				now = 0;
				js.push(-1);
			} else {
				now = now * 10 + c[i] - '0';
			}
		return num.pop() + now * js.pop();
	}
}