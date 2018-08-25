package leetcode;

public class Solution67 {
	public static void main(String args[]){
		Solution67 s = new Solution67();
		System.out.println(s.addBinary("101", "11011"));
	}
	public String addBinary(String a, String b) {
		if (b.length() > a.length()){
			String c = b;
			b = a;
			a = c;
		}
		char[] ch = a.toCharArray();
		int q = a.length() - b.length();
		for (int i = 0; i < b.length(); i ++)
			if (b.charAt(i) == '1') ch[i + q] ++;
		for (int i = ch.length - 1; i > 0; i --)
			if (ch[i] > '1'){
				ch[i - 1] ++;
				ch[i] -= 2;
			}
		if (ch[0] > '1'){
			char[] result = new char[ch.length + 1];
			result[0] = '1';result[1] = (char)(ch[0] - 2);
			for (int i = 2; i <= ch.length; i ++) result[i] = ch[i - 1];
			return String.valueOf(result);
		}
		return String.valueOf(ch);
	}
}