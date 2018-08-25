package leetcode;

public class Solutionb564 {
	
	public static void main(String args[]){
		Solutionb564 s = new Solutionb564();
		System.out.println(s.nearestPalindromic("11911"));
	}
	private long min = Long.MAX_VALUE, result = Long.MAX_VALUE, pre;
	public String nearestPalindromic(String n) {
		if (n.equals("0")) return "1";
		if (n.length() == 1) return (Long.parseLong(n) - 1) + "";
		pre = Long.parseLong(n);
		String st = "", ts = "1", ss = "";
		if (n.length() != 1){
			for (int i = 1; i < n.length(); i ++) st += "9";
			check(st);
		}
		for (int i = 1; i < n.length(); i ++) ts += "0";
		check(ts + "1");
		st = (Long.parseLong(n.substring(0, (n.length() + 1) / 2)) + 1) + "";
		ts = (Long.parseLong(n.substring(0, (n.length() + 1) / 2)) - 1) + "";
		ss = n.substring(0, (n.length() + 1) / 2);
		if (st.length() != ss.length()) st = ss;
		if (ts.length() != ss.length()) ts = ss;
		for (int i = n.length() / 2 - 1; i >= 0; i --){
			st += st.charAt(i);
			ts += ts.charAt(i);
			ss += ss.charAt(i);
		}
		check(st);
		check(ts);
		check(ss);
		return result + "";
	}
	private void check(String st) {
		if (st.startsWith("0")) return;
		long now = Long.parseLong(st);
		long n = Math.abs(now - pre);
		if (n == 0) return;
		if (n <= min){
			if (n < min || n == min && now < result) result = now;
			min = n;
		}
	}
}