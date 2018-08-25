package leetcode;

public class Solutionb238 {
	
	public static void main(String args[]){
		Solutionb238 s = new Solutionb238();
		int[] x = {1, 2, 3, 4};
		int[] a = s.productExceptSelf(x);
		for (int i = 0; i < a.length; i ++) System.out.println(a[i]);
	}
	public int[] productExceptSelf(int[] nums) {
		if (nums.length == 0) return null;
		if (nums.length == 1) return new int[]{0};
		int[] result = new int[nums.length];
		result[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i --) result[i] = result[i + 1] * nums[i];
		for (int i = 1; i < nums.length; i ++) nums[i] *= nums[i - 1];
		result[0] = result[1];
		for (int i = 1; i < nums.length - 1; i ++) result[i] = result[i + 1] * nums[i - 1];
		result[nums.length - 1] = nums[nums.length - 2];
		return result;
	}
}