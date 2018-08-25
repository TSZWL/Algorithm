package leetcode;

public class Solutionb300 {
	
	public static void main(String args[]){
		Solutionb300 s = new Solutionb300();
		int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(s.lengthOfLIS(a));
	}
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;
		int[] f = new int[nums.length + 1];
		f[1] = nums[0];
		int head = 1, tail = 1;
		for (int i = 1; i < nums.length; i ++){
			int p = head, q = tail;
			while (p < q){
				int mid = (p + q) / 2;
				if (f[mid] < nums[i]) p = mid + 1; else q = mid;
			}
			if (f[p] < nums[i]){
				tail ++;
				f[tail] = nums[i];
			} else f[p] = nums[i];
		}
		return tail;
	}
}