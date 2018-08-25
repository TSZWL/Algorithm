package leetcode;

class NumArray_2 {

	int a, b;
	int[] f, g;
	public NumArray_2(int[] nums) {
		a = 0;
		b = nums.length - 1;
		f = new int[nums.length * 3];
		g = new int[nums.length];
		for (int i = 0; i < nums.length; i ++){
			g[i] = nums[i];
			change(i, nums[i]);
		}
	}
	
	public void update(int i, int val) {
		change(i, val - g[i]);
		g[i] = val;
	}
	
	public int sumRange(int i, int j) {
		return find(0, i, j, a, b);
	}
	
	private int find(int r, int i, int j, int a2, int b2) {
		if (i <= a2 && j >= b2) return f[r];
		int mid = (a2 + b2) >> 1;
		if (i > mid) return find(r * 2 + 2, i, j, mid + 1, b2);
		if (j <= mid) return find(r * 2 + 1, i, j, a2, mid);
		return find(r * 2 + 1, i, j, a2, mid) + find(r * 2 + 2, i, j, mid + 1, b2);
	}

	private void change(int i, int j){
		int head = a, tail = b, now = 0;
		while (head < tail){
			f[now] += j;
			int mid = (head + tail) >> 1;
			if (i > mid){
				head = mid + 1;
				now = now * 2 + 2;
			} else {
				tail = mid;
				now = now * 2 + 1;
			}
		}
		f[now] += j;
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
/*
 * 用树状数组写起来更方便而且更快
 * sumRange
 * return find(j + 1) - find(i);
 * find
 * for (int j = i; j > 0; j -= (j & -j)) {
 *     result += f[j];
 * }
 * update
 * int diff = val - g[i + 1];
 * for (int j = i + 1; j < nums.length; j += (j & -j)) {
 *     f[j] += diff;
 * }
 * g[i + 1] = val;
 */