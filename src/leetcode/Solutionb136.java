package leetcode;

public class Solutionb136 {
	
	public static void main(String args[]){
		Solutionb136 s = new Solutionb136();
		int[] a = {3, -1, -1, 5, 5};
		System.out.println(s.singleNumber(a));
	}
	//xor ��������;^self;������;a xor b = c(����
	public int singleNumber(int[] nums) {
		int x = 0;
		for (int i = 0; i < nums.length; i ++) x ^= nums[i];
		return x;
	}
}