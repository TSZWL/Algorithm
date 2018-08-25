package leetcode;

public class Solutionb215 {
	
	public static void main(String args[]){
		Solutionb215 s = new Solutionb215();
		int[] a = {3,2,1,5,6,4};
		System.out.println(s.findKthLargest(a, 5));
	}
	//可以每次都选第一个，然后第一个不参与交换，最后再比较
	//这样如果正好选中了第k个就可以返回了
	public int findKthLargest(int[] nums, int k) {
		return qsort(nums, 0, nums.length - 1, k - 1);
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