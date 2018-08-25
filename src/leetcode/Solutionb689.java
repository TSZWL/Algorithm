package leetcode;

public class Solutionb689 {
	
	public static void main(String args[]){
		Solutionb689 s = new Solutionb689();
		int[] a = {7,13,20,19,19,2,10,1,1,19};
		int[] r = s.maxSumOfThreeSubarrays(a, 3);
		for (int i = 0; i < 3; i ++) System.out.println(r[i]);
	}
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] sum = new int[nums.length - k + 1];
		int[] left = new int[nums.length - k + 1];
		int[] right = new int[nums.length - k + 1];
		int[] lp = new int[nums.length - k + 1];
		int[] rp = new int[nums.length - k + 1];
		sum[0] = nums[0];
		for (int i = 1; i < k; i ++) sum[0] += nums[i];
		for (int i = k; i < nums.length; i ++)
			sum[i - k + 1] = sum[i - k] + nums[i] - nums[i - k];
		left[0] = sum[0];
		right[nums.length - k] = sum[nums.length - k];
		rp[nums.length - k] = nums.length - k;
		for (int i = 1; i <= nums.length - k; i ++)
			if (sum[i] > left[i - 1]){
				lp[i] = i;
				left[i] = sum[i];
			} else {
				lp[i] = lp[i - 1];
				left[i] = left[i - 1];
			}
		for (int i = nums.length - k - 1; i >= 0; i --)
			if (sum[i] > right[i + 1]){
				rp[i] = i;
				right[i] = sum[i];
			} else {
				rp[i] = rp[i + 1];
				right[i] = right[i + 1];
			}
		int result = 0, r1 = 0, r2 = 0, r3 = 0;
		for (int i = k; i <= nums.length - k - k; i ++)
			if (check(left[i - k] + sum[i] + right[i + k], result, lp[i - k], r1)){
				result = left[i - k] + sum[i] + right[i + k];
				r1 = lp[i - k];
				r2 = i;
				r3 = rp[i + k];
			}
		return new int[]{r1, r2, r3};
	}
	private boolean check(int i, int result, int j, int r1) {
		if (i < result) return false;
		if (i > result) return true;
		if (r1 > j) return true;
		return false;
	}
}