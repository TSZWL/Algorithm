package leetcode;

public class Solutionb462 {
	
	public static void main(String args[]){
	}
	public int minMoves2(int[] nums) {
		int mid = qsort(nums, 0, nums.length - 1, nums.length / 2), result = 0;
		for (int i = 0; i < nums.length; i ++) result += Math.abs(nums[i] - mid);
		return result;
	}
	private int qsort(int[] nums, int p, int r, int k) {
		if (p < r){
			int x = nums[(int)Math.floor(p + Math.random() * (r - p + 1))];
			int i = p - 1, j = r + 1;
			while (true){
				do j --; while (nums[j] < x);
				do i ++; while (nums[i] > x);
				if (i < j) swap(nums, i, j); else break;
			}
			if (j >= k) return qsort(nums, p, j, k);
			return qsort(nums, j + 1, r, k);
		} else return nums[p];
	}
	private void swap(int[] nums, int x, int y){
		int n = nums[x];
		nums[x] = nums[y];
		nums[y] = n;
	}
}