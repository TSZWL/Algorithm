package leetcode;

public class Solution20 {
	public static void main(String args[]){
		Solution20 s = new Solution20();
		System.out.println(s.isValid("()[]"));
	}
	public boolean isValid(String s) {
		int num = 0, l = s.length();
		char[] c = new char[s.length()];
		for (int i = 0; i < l; i ++){
			char x = s.charAt(i);
			if (x == ')'){
				num --;
				if ((num == -1) || (c[num] != '(')) return false;
			} else if (x == ']'){
				num --;
				if ((num == -1) || (c[num] != '[')) return false;
			} else if (x == '}'){
				num --;
				if ((num == -1) || (c[num] != '{')) return false;				
			} else {
				c[num] = x;
				num ++;
			}
		}
		if (num != 0) return false;
		return true;
	}
}