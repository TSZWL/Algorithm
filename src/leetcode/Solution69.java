package leetcode;

public class Solution69 {
	
	public static void main(String args[]){
		Solution69 s = new Solution69();
		System.out.println(s.mySqrt(101));
	}
	public int mySqrt(int x) {
		return (int)Math.floor(Math.sqrt(x));
	}
/*
long res = (long)x;
while (res * res > x) {
	res = (res + x / res) / 2;
}
*/
}