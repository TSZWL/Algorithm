package leetcode;

import java.util.Stack;

public class Solutionb316 {
	
	public static void main(String args[]){
		Solutionb316 s = new Solutionb316();
		System.out.println(s.removeDuplicateLetters("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"));
	}
	//找到首先没有的字母+单调队列
	public String removeDuplicateLetters(String s) {
		char[] c = s.toCharArray();
		int[] num = new int[26];
		int i = 0;
		StringBuilder result = new StringBuilder();
		int[] x = new int[26];
		for (int j = 0; j < c.length; j ++) num[c[j] - 'a'] ++;
		while (i < c.length){
			int min = 26, now = c[i] - 'a', pos = 0;
			boolean[] b = new boolean[26];
			while (num[now] != 1){
				if (num[now] > 1){
					num[now] --;
					if (now < min){
						min = now;
						pos = i;
						System.arraycopy(num, 0, x, 0, 26);
					}
					b[now] = true;
				}
				i ++;
				if (i == c.length){
					if (num[c[i - 1] - 'a'] != 1) return result.toString();
					break;
				}
				now = c[i] - 'a';
			}
			if (now < min){
				num[now] = 0;
				result.append((char)(now + 'a'));
			} else {
				int l = i + 1;
				i = pos;
				System.arraycopy(x, 0, num, 0, 26);
				Stack<Integer> st = new Stack<Integer>();
				boolean[] d = new boolean[26];
				while (i < l){
					int t = c[i] - 'a';
					if (num[t] != 0){
						num[t] --;
						if (t <= now && !d[t]){
							while (st.size() != 0 && st.peek() > t) d[st.pop()] = false;
							st.push(t);
							d[t] = true;
							if (t == now){
								pos = i;
								System.arraycopy(num, 0, x, 0, 26);
							}
						}
					}
					i ++;
				}
				i = pos + 1;
				System.arraycopy(x, 0, num, 0, 26);
				for (Integer xx : st){
					result.append((char)(xx + 'a'));
					num[xx] = 0;
				}
			}
		}
		return result.toString();
	}
/*不用这么麻烦，直接单调队列，记录每个字母剩余的个数
 *当该出栈的字母剩余个数为0时，拒绝出栈即可
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        boolean[] used = new boolean[26];
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++;
        }
        
        char[] stack = new char[s.length()];
        int p = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!used[c - 'a']) {
                while (p > 0 && c < stack[p - 1] && count[stack[p - 1] - 'a'] > 0) {
                    used[stack[p - 1] - 'a'] = false;
                    p--;
                }
                
                stack[p++] = c;
                used[c - 'a'] = true;
            }
            
            count[c - 'a']--;
        }
        
        return new String(stack, 0, p);
    }
*/
	
}