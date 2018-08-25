package leetcode;

public class Solution03 {
	public static void main(String args[]){
		Solution03 s = new Solution03();
		System.out.println(s.lengthOfLongestSubstring("wionovac"));
	}
	public int lengthOfLongestSubstring(String s) {
		int[] b = new int[200];
		int head = 0, tail = 0, result = 0;
		while (tail < s.length()){
			int x = s.charAt(tail);
			b[x]++;
			tail++;
			if (b[x] == 2)
				while (b[x] == 2){
					int y = s.charAt(head);
					b[y]--;
					head++;
				}
			if (tail - head > result) result = tail - head;
		}
		return result;
	}
}