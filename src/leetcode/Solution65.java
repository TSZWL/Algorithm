package leetcode;

public class Solution65 {
	
	public static void main(String args[]){
		Solution65 s = new Solution65();
		System.out.println(s.isNumber("3."));
	}
	public boolean isNumber(String s) {
		while (s.startsWith(" ")) s = s.substring(1);
		while (s.endsWith(" ")) s = s.substring(0, s.length() - 1);
		if (s.contains(" ") || s.length() == 0) return false;
		if (s.charAt(s.length() - 1) != '.')
			if (s.charAt(s.length() - 1) > '9' || s.charAt(s.length() - 1) < '0') return false;
		String[] st = s.split("e");
		if (st.length > 2) return false;
		if (st.length == 1){
			try{
				Double.parseDouble(s);
				return true;
			} catch (Exception e){
				return false;
			}
		} else {
			try{
				Double.parseDouble(st[0]);
				Long.parseLong(st[1]);
				return true;
			} catch (Exception e){
				return false;
			}
		}
	}
}