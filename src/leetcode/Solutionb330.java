package leetcode;

public class Solutionb330 {
	
	public static void main(String args[]){
		Solutionb330 s = new Solutionb330();
		int[] a = {1, 3};
		System.out.println(s.minPatches(a, 6));
	}
	public int minPatches(int[] nums, int n) {
		long sum = 0;
		int result = 0, i = 0;
		while (sum < n){
			while (i < nums.length && nums[i] <= sum + 1){
				sum += nums[i];
				i ++;
			}
			if (sum >= n) break;
			sum += sum + 1;
			result ++;
		}
		return result;
	}
}