package leetcode;

public class Solution58 {
	
	public static void main(String args[]){
		Solution58 s = new Solution58();
		System.out.println(s.lengthOfLastWord("Hello World"));
	}
	public int lengthOfLastWord(String s) {
		String[] st = s.split(" ");
		for (int i = st.length - 1; i >= 0; i --)
			if (st[i].length() != 0) return st[i].length();
		return 0;
	}
}