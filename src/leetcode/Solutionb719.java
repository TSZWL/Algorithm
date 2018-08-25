package leetcode;

public class Solutionb719 {
	
	public static void main(String args[]){
		Solutionb719 s = new Solutionb719();
		int[] a = {2,2,0,1,1,0,0,1,2,0};
		System.out.println(s.smallestDistancePair(a, 2));
	}
	public int smallestDistancePair(int[] nums, int k) {
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i ++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		int[] g = new int[max + 1];
		for (int i = 0; i < nums.length; i ++) g[nums[i]] ++;
		for (int i = min + 1; i <= max; i ++) g[i] += g[i - 1];
		int head = 0, tail = max - min;
		while (head < tail) {
			int mid = (head + tail) / 2, total = 0;
			for (int i = 0; i < nums.length; i ++) {
				int x = Math.max(min, nums[i] - mid) - 1;
				int y = Math.min(max, nums[i] + mid);
				if (x < 0) total += g[y] - 1; else total += g[y] - g[x] - 1;
			}
			if (total / 2 >= k) tail = mid; else head = mid + 1;
		}
		return head;
	}
}
/*
	//。。根本不用用数组g统计到i累计有g[i]个点
	//可以排序之后用两个变量l和r推进计算有几个比i小mid的值，不除以2
	Arrays.sort(nums);
	for (int right = 0; right < nums.length; ++right) {
		while (nums[right] - nums[left] > mi) left++;
		count += right - left;
	}
*/