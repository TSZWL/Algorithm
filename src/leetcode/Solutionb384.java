package leetcode;

class Solution_4 {

	int[] pre, now;
	public Solution_4(int[] nums) {
		pre = new int[nums.length];
		now = new int[nums.length];
		for (int i = 0; i < nums.length; i ++) {
			pre[i] = nums[i];
			now[i] = nums[i];
		}
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return pre;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		for (int i = now.length - 1; i >= 0; i --) {
			int x = (int)Math.floor(Math.random() * (i + 1));
			int n = now[x];
			now[x] = now[i];
			now[i] = n;
		}
		return now;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */