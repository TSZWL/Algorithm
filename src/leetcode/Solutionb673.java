package leetcode;

public class Solutionb673 {
	
	public static void main(String args[]){
		Solutionb673 s = new Solutionb673();
		int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(s.findNumberOfLIS(a));
	}
	public int findNumberOfLIS(int[] nums) {
		int[] f = new int[nums.length];
		int[] n = new int[nums.length];
		for (int i = 0; i < nums.length; i ++){
			f[i] = 1;
			n[i] = 1;
		}
		int max = 1, result = 0;
		for (int i = 1; i < nums.length; i ++){
			for (int j = 0 ; j < i; j ++)
				if (nums[j] < nums[i]){
					int l = f[j] + 1;
					if (l > f[i]){
						f[i] = l;
						n[i] = n[j];
					} else if (l == f[i]){
						n[i] += n[j];
					}
				}
			max = Math.max(max, f[i]);
		}
		for (int i = 0; i < nums.length; i ++)
			if (max == f[i]) result += n[i];
		return result;
	}
}