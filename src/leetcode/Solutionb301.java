package leetcode;

import java.util.*;

public class Solutionb301 {
	
	public static void main(String args[]){
		Solutionb301 s = new Solutionb301();
		List<String> r = s.removeInvalidParentheses("(");
		for (String i : r) System.out.println(i);
	}
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<String>();
		Set<String> before = new HashSet<String>();
		Set<String> after = new HashSet<String>();
		if (s.length() == 0){
			result.add("");
			return result;
		}
		char[] c = s.toCharArray();
		int[] f = new int[c.length];
		int min = -1;
		if (c[0] == '(') f[0] = 1;
		else if (c[0] == ')'){
			f[0] = -1;
			min = 0;
		}
		for (int i = 1; i < c.length; i ++){
			if (c[i] == '(') f[i] = f[i - 1] + 1;
			else if (c[i] == ')') f[i] = f[i - 1] - 1;
			else f[i] = f[i - 1];
			if (min == -1){
				if (f[i] < 0) min = i;
			} else if (f[i] < f[min]) min = i;
		}
		if (min != -1){
			dfsb(before, "", 0, min, 0, -f[min], c, f);
		} else before.add("");
		if (min != c.length - 1){
			int[] g = new int[c.length];
			if (min != -1)
				for (int i = min + 1; i < c.length; i ++) f[i] -= f[min];
			if (c[c.length - 1] == '(') g[c.length - 1] = 1;
			for (int i = c.length - 2; i > min; i --){
				if (f[i] > f[i + 1]) f[i] = f[i + 1];
				if (c[i] == '(') g[i] = g[i + 1] + 1; else g[i] = g[i + 1];
			}
			dfsa(after, "", min + 1, c.length, 0, f[c.length - 1], c, f, g);
		} else after.add("");
		for (String a : before)
			for (String b : after) result.add(a + b);
		return result;
	}
	private void dfsb(Set<String> before, String s, int a, int b, int c, int d, char[] ch, int[] f) {
		if (a > b){
			before.add(s);
			return;
		}
		if (ch[a] != ')'){
			dfsb(before, s + ch[a], a + 1, b, c, d, ch, f);
			return;
		}
		if (c != d) dfsb(before, s, a + 1, b, c + 1, d, ch, f);
		if (f[a] + c >= 0) dfsb(before, s + ch[a], a + 1, b, c, d, ch, f);
	}
	private void dfsa(Set<String> after, String s, int a, int b, int c, int d, char[] ch, int[] f, int[] g) {
		if (a == b){
			after.add(s);
			return;
		}
		if (ch[a] != '('){
			dfsa(after, s + ch[a], a + 1, b, c, d, ch, f, g);
			return;
		}
		if (f[a] - c >
		0) dfsa(after, s, a + 1, b, c + 1, d, ch, f, g);
		if (c + g[a] > d) dfsa(after, s + ch[a], a + 1, b, c, d, ch, f, g);
	}
}
/*
class Solution {
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		if (s == null){
			return result;
		}        
		remove(s, result, 0, 0, '(', ')');
		return result;
	}
	//从头到尾扫描
	private void remove(String s, List<String> result, int left, int right, char open, char close) {
		for (int i = left, cnt = 0; i < s.length(); i++) {
			if (s.charAt(i) == open){
				cnt++;
			} 
			if (s.charAt(i) == close){
				cnt--;
			}
			if (cnt >= 0){
				continue;
			}
			//遇到为负数的值则删除前面任意一组连续)的第一个
			for (int j = right; j <= i; j++) {
				if (s.charAt(j) == close && (j == right || s.charAt(j - 1) != close)) {
					//分别继续统计剩下的字符串  从i开始  下次删除的位置一定比这次的靠后(j)
					remove(s.substring(0, j) + s.substring(j + 1), result, i, j, open, close);
				}
			}
			return;
		}
		//如果当前字符串已经满足了情况 则翻转字符串判断(数量是否合适
		String sb = new StringBuilder(s).reverse().toString();
		if (open == '(') {
			remove(sb, result, 0, 0, ')', '(');
		}else{
			result.add(sb);
		}
	}
}
*/