package leetcode;

public class Solutionb164 {
	public static void main(String args[]){
		Solutionb164 s = new Solutionb164();
		int[] a = {1,2,3,4,5,7};
		System.out.println(s.maximumGap(a));
	}
	//果然是先离散再桶排序。。
	//ma,mi不记余数，而记原数
	public int maximumGap(int[] nums) {
		int max = 0, min = Integer.MAX_VALUE, n = nums.length;
		if (n < 2) return 0;
		for (int i = 0; i < n; i ++){
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		int len = (max - min - 1) / (n - 1) + 1;
		int[] ma = new int[n];
		int[] mi = new int[n];
		for (int i = 0; i < n; i ++){
			ma[i] = -1;
			mi[i] = len;
		}
		for (int i = 0; i < n; i ++){
			int j = (nums[i] - min) / len;
			int l = (nums[i] - min) % len;
			ma[j] = Math.max(ma[j], l);
			mi[j] = Math.min(mi[j], l);
		}
		int result = 0, pre = 0;
		for (int i = 1; i < n; i ++)
			if (ma[i] != -1){
				result = Math.max(result, len * (i - pre) + mi[i] - ma[pre]);
				pre = i;
			}
		return result;
	}
}