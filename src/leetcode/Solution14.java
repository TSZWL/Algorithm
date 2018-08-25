package leetcode;

public class Solution14 {
	public static void main(String args[]){
		Solution14 s = new Solution14();
		String[] a = {"123", "123", "123"};
		System.out.println(s.longestCommonPrefix(a));
	}
	public String longestCommonPrefix(String[] strs) {
		String st = "";
		int min = 2147483647, l = strs.length;
		if (l == 0) return st;
		boolean get = true;
		for (int i = 0; i < l; i ++)
			if (min > strs[i].length()) min = strs[i].length();
		for (int i = 0; i < min; i ++){
			for (int j = 1; j < l; j ++)
				if (strs[j].charAt(i) != strs[0].charAt(i)){
					get = false;
					break;
				}
			if (!get) break;
			st += strs[0].charAt(i);
		}
		return st;
	}
}