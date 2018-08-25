package leetcode;

public class Solutionb327 {
	
	public static void main(String args[]){
		Solutionb327 s = new Solutionb327();
		int[] a = {-2147483647,0,-2147483647,2147483647};
		System.out.println(s.countRangeSum(a, -564, 3864));
	}
	//b315
	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] sum = new long[nums.length + 1];
		for (int i = 1; i < sum.length; i ++) sum[i] = sum[i - 1] + nums[i - 1];
		int[] pos = new int[sum.length];
		for (int i = 0; i < sum.length; i ++) pos[i] = i;
		return sort(sum, pos, 0, nums.length, lower, upper);
	}
	private int sort(long[] sum, int[] pos, int a, int b, int lower, int upper) {
		if (a >= b) return 0;
		int t = (a + b) / 2;
		int res = sort(sum, pos, a, t, lower, upper) + sort(sum, pos, t + 1, b, lower, upper);
		int[] l = new int[b - a + 1];
		int i = a, j = t + 1, n = 0, ll = t + 1, uu = t + 1;
		while (n <= b - a)
			if (i > t){
				l[n ++] = pos[j ++];
			} else if (j > b || sum[pos[i]] <= sum[pos[j]]){
				while (ll <= b && sum[pos[ll]] - sum[pos[i]] < lower) ll ++;
				while (uu <= b && sum[pos[uu]] - sum[pos[i]] <= upper) uu ++;
				l[n ++] = pos[i ++];
				res += uu - ll;
			} else {
				l[n ++] = pos[j ++];
			}
		for (int k = 0; k <= b - a; k ++) pos[a + k] = l[k];
		return res;
	}
}