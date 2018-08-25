package leetcode;

public class Solution29 {
	
	public static void main(String args[]){
		Solution29 s = new Solution29();
		System.out.println(s.divide(-2147483648, -1));
	}
	//orÄ£ÄâÊúÊ½
	public int divide(int dividend, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
		long result = 0, d = 1;
		if (((divisor > 0) && (dividend < 0)) || ((divisor < 0) && (dividend > 0))) d = -1;
		long x = divisor, y = 1, z = dividend;
		if (x < 0) x = -x;
		if (z < 0) z = -z;
		if (x > z) return 0;
		while (x <= z){
			x = x << 1;
			y = y << 1;
		}
		while (y != 0){
			if (x <= z){
				z -= x;
				result += y;
			}
			x = x >> 1;
			y = y >> 1;
		}
		if (d == -1) result = -result;
		if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)) return Integer.MAX_VALUE;
		return (int)result;
	}
}