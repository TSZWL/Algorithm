package leetcode;

public class Solutionb260 {
	
	public static void main(String args[]){
		Solutionb260 s = new Solutionb260();
		int[] a = {3, -1, 5, 5, -1, 6};
		int[] b = s.singleNumber(a);
		System.out.println(b[0] + " " + b[1]);
	}
	//1 xor 0 = 1，将数字分成两组
	public int[] singleNumber(int[] nums) {
		int x = 0, n = 1;
		for (int i = 0; i < nums.length; i ++) x = x ^ nums[i];
		while ((x & n) == 0) n = n << 1;
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i ++) 
			if ((nums[i] & n) == 0) result[0] ^= nums[i]; else result[1] ^= nums[i];
		return result;
	}
}