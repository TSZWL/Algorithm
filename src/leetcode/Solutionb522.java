package leetcode;

public class Solutionb522 {
	
	public static void main(String args[]){
	}
	public int findLUSlength(String[] strs) {
		int result = -1;
		for (int i = 0; i < strs.length; i ++){
			if (result >= strs[i].length()) continue;
			boolean b = true;
			for (int j = 0; j < strs.length; j ++)
				if (i != j && check(strs[i], strs[j])){
					b = false;
					break;
				}
			if (b) result = strs[i].length();
		}
		return result;
	}
	private boolean check(String a, String b) {
		if (a.length() == 0) return true;
		if (a.length() > b.length()) return false;
		char[] c = a.toCharArray();
		char[] d = b.toCharArray();
		int now = 0;
		for (int i = 0; i < d.length; i ++)
			if (d[i] == c[now]){
				now ++;
				if (now == c.length) return true;
			}
		return false;
	}
}