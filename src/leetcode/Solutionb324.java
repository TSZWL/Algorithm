package leetcode;

public class Solutionb324 {
	
	public static void main(String args[]){
		Solutionb324 s = new Solutionb324();
		int[] a = {1,1,2,1,2,2,1};
		s.wiggleSort(a);
		for (int i = 0; i < a.length; i ++) System.out.println(a[i]);
	}
	//结合b215，我放弃了思考。。O(n)~O(1)
	public void wiggleSort(int[] nums) {
		int mid = qsort(nums, 0, nums.length - 1, nums.length / 2);
		int left = 1, right = nums.length - 2 + nums.length % 2, i = 1;
		while (i < nums.length){
			if (nums[i] > mid){
				swap(nums, left, i);
				i += 2;
				left += 2;
			} else if (nums[i] < mid){
				swap(nums, right, i);
				right -= 2;
			} else i += 2;
		}
		i = 0;
		while (i <= right){
			if (nums[i] > mid){
				swap(nums, left, i);
				left += 2;
			} else if (nums[i] < mid){
				swap(nums, right, i);
				right -= 2;
			} else i += 2;
		}		
	}
	private int qsort(int[] nums, int p, int r, int k) {
		if (p < r){
			int x = nums[(int)Math.floor(p + Math.random() * (r - p + 1))];
			int i = p - 1, j = r + 1;
			while (true){
				do j --; while (nums[j] > x);
				do i ++; while (nums[i] < x);
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