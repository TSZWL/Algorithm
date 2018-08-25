package leetcode;

public class Solution66 {
	public static void main(String args[]){
		Solution66 s = new Solution66();
		int[] a = {9, 9};
		int[] b = s.plusOne(a);
		for (int i = 0; i < b.length; i ++) System.out.println(b[i]);
	}
	public int[] plusOne(int[] digits) {
		int l = digits.length;
		digits[l - 1] ++;
		for (int i = l - 1; i > 0; i --)
			if (digits[i] == 10){
				digits[i - 1] ++;
				digits[i] = 0;
			}
		if (digits[0] == 10){
			int[] result = new int[l + 1];
			result[0] = 1;result[1] = 0;
			for (int i = 2; i <= l; i ++) result[i] = digits[i - 1];
			return result;
		}
		return digits;
	}
}