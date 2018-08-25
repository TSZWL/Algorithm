package leetcode;

public class Solution07 {
	public static void main(String args[]){
	}
	public int reverse(int x) {
		String st = x + "", ts = "", head = "";
		if (st.charAt(0) == '-'){
			head = "-";
			st = st.substring(1);
		}
		int l = st.length();
		for (int i = 0; i < l; i++){
			ts += st.charAt(l - 1 - i);
		}
		while ((ts.charAt(0) == '0') && (ts.length() != 1)){
			ts = ts.substring(1);
		}
		long a = Long.parseLong(ts);
		if (a > 2147483647) return 0;
		else return Integer.parseInt(head + a);
	}
}