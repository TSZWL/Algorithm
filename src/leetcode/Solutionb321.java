package leetcode;

public class Solutionb321 {
	public static void main(String args[]){
		Solutionb321 s = new Solutionb321();
		int[] a = {7,6,1,9,3,2,3,1,1};
		int[] b = {4,0,9,9,0,5,5,4,7};
		int[] r = s.maxNumber(a, b, 9);
		for (int i = 0; i < r.length; i ++) System.out.print(r[i]);
		System.out.println();
	}
	//合并之后得到的数字最大->合并之前的数字在a和b中分别最大
	//ab中最大的可以用贪心来取(单调队列)|合并也使用贪心合并
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int[] result = new int[k];
		for (int i = Math.max(0, k - l2); i <= Math.min(k, l1); i ++){
			int[] x = get(nums1, i);
			int[] y = get(nums2, k - i);
			int[] now = merge(x, y, k);
			result = compare(result, 0, now, 0) ? result : now;
		}
		return result;
	}
	private int[] merge(int[] x, int[] y, int k) {
		int[] now = new int[k];
		for (int i = 0, l1 = 0, l2 = 0; i < k; i ++)
			now[i] = compare(x, l1, y, l2) ? x[l1 ++] : y[l2 ++];
		return now;
	}
	private boolean compare(int[] x, int l1, int[] y, int l2) {
		int a = x.length, b = y.length;
		while (l1 < a && l2 < b && x[l1] == y[l2]){
			l1 ++;
			l2 ++;
		}
		if (l2 == b) return true;
		if (l1 == a) return false;
		return x[l1] > y[l2] ? true : false;
	}
	private int[] get(int[] nums, int k) {
		int l = nums.length, tail = 0, max = l - k;
		int[] result = new int[k];
		for (int i = 0; i < l; i ++){
			while (tail > 0 && max > 0 && result[tail - 1] < nums[i]){
				tail --;
				max --;
			}
			if (tail != k) result[tail ++] = nums[i]; else max --;
		}
		return result;
	}
}