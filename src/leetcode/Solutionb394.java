package leetcode;

import java.util.*;

public class Solutionb394 {
	public static void main(String args[]){
		Solutionb394 s = new Solutionb394();
		System.out.println(s.decodeString("10[abc]"));
	}
	public String decodeString(String s) {
		char[] c = s.toCharArray();
		int rnum = 0;
		String rst = "";
		Stack<String> st = new Stack<String>();
		Stack<Integer> num = new Stack<Integer>();
		for (int i = 0; i < c.length; i ++)
			if (c[i] >= '0' && c[i] <= '9'){
				rnum = rnum * 10 + c[i] - '0';
			} else if (c[i] == '['){
				st.add(rst);
				num.add(rnum);
				rst = "";
				rnum = 0;
			} else if (c[i] == ']'){
				String n = "";
				int len = num.pop();
				for (int j = 0; j < len; j ++) n += rst;
				rst = st.pop() + n;
			} else {
				rst += c[i];
			}
		return rst;
	}
}