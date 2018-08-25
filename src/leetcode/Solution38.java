package leetcode;

public class Solution38 {
	public static void main(String args[]){
		Solution38 s = new Solution38();
		System.out.println(s.countAndSay(5));
	}
	public String countAndSay(int n) {
		String now = "1", next;
		for (int i = 1; i < n; i ++){
			next = "";
			char c = now.charAt(0);
			int num = 1;
			for (int j = 1; j < now.length(); j ++)
				if (c == now.charAt(j)) num ++;
				else {
					next += num + "" + c;
					c = now.charAt(j);
					num = 1;
				}
			next += num + "" + c;
			now = next;
		}
		return now;
	}
}