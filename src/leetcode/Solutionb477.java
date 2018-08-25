package leetcode;

public class Solutionb477 {
	
	public static void main(String args[]){
		Solutionb477 s = new Solutionb477();
		int[] nums = {4, 14, 2};
		System.out.println(s.totalHammingDistance(nums));
	}
	public int totalHammingDistance(int[] nums) {
		int result = 0;
		int[] b = new int[31];
		int[] f = new int[31];
		b[0] = 1;
		for (int i = 1; i < 31; i ++) b[i] = b[i - 1] << 1;
		for (int i = 0; i < nums.length; i ++)
			for (int j = 0; j < 31; j ++){
				if (b[j] > nums[i]) break;
				if ((nums[i] & b[j]) != 0) f[j] ++;
			}
		for (int i = 0; i < 31; i ++)
			result += f[i] * (nums.length - f[i]);
		return result;
	}
}