package leetcode;

public class Solution28 {
	
	public static void main(String args[]){
		Solution28 s = new Solution28();
		System.out.println(s.strStr("", ""));
	}
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
}