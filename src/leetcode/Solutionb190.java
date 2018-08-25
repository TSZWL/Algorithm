package leetcode;

public class Solutionb190 {
	
	public static void main(String args[]){
		Solutionb190 s = new Solutionb190();
		System.out.println(s.reverseBits(43261596));
	}
	//直接写1<<31不行(为负数)
	public int reverseBits(int n) {
		long x = 1, result = 0, y = 1 << 30;
		y = y << 1;
		if ((n & x) != 0) result = y;
		for (int i = 1; i <= 31; i ++){
			x = x << 1;
			y = y >> 1;
			if ((n & x) != 0) result += y;
		}
		return (int)result; 
	}
}