package leetcode;

import java.util.Arrays;

public class Solution16 {
	public static void main(String args[]){
		Solution16 s = new Solution16();
		int[] a = {-1, 0, 1, 1, 55};
		int b = 3;
		System.out.println(s.threeSumClosest(a, b));
	}
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int l = nums.length;
		if (l < 3) return 0;
		int min = 2147483647, result = 0;
		for (int i = 0; i < l - 2; i ++){
			int head = i + 1, tail = l - 1;
			while (head < tail){
				int sum = nums[i] + nums[head] + nums[tail];
				if (min > Math.abs(sum - target)){
					min = Math.abs(sum - target);
					result = sum;
				}
				if (sum == target){
					return target;
				} else if (sum > target){
					tail --;
					while ((nums[tail] == nums[tail - 1]) && (tail > head + 1)) tail --;
				} else {
					head ++;
					while ((nums[tail] == nums[tail - 1]) && (tail > head + 1)) tail --;
				}
			}
		}
		return result;
	}
}