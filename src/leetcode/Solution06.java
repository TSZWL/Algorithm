package leetcode;

public class Solution06 {
	public static void main(String args[]){
	}
	public String convert(String s, int numRows) {
		if (numRows <= 1) return s;
		int l = s.length(), t = 0, r = 2 * numRows - 2;
		String rlt = "";
		while (t < l){
			rlt += s.charAt(t);
			t += r;
		}
		for (int i = 1; i < numRows - 1; i++){
			t = i;
			int t1 = 2 * i, t2 = r - 2 * i;
			while (t < l){
				rlt += s.charAt(t);
				int n = t1;
				t1 = t2;
				t2 = n;
				t += t1;
			}
		}
		t = numRows - 1;
		while (t < l){
			rlt += s.charAt(t);
			t += r;
		}
		return rlt;
	}
}