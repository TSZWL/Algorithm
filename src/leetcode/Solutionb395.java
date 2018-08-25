package leetcode;

public class Solutionb395 {
	public static void main(String args[]){
		Solutionb395 s = new Solutionb395();
		System.out.println(s.longestSubstring("ababbc", 2));
	}
	//单纯的扫一遍不能解决问题，按字母种类分别扫是一个不错的想法
	public int longestSubstring(String s, int k) {
		int result = 0;
		char[] c = s.toCharArray();
		for (int i = 1; i < 26; i ++) {
			int[] f = new int[26];
			int head = 0, tail = 0, l = 0, m = 0;
			while (tail < c.length) {
				if (l <= i) {
					int x = c[tail ++] - 'a';
					if (f[x] == 0) l ++;
					f[x] ++;
					if (f[x] == k) m ++;
				} else {
					int x = c[head ++] - 'a';
					if (f[x] == k) m --;
					f[x] --;
					if (f[x] == 0) l --;
				}
				if (l == i && m == i) result = Math.max(result, tail - head);
			}
		}
		return result;
	}
}