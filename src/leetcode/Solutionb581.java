package leetcode;

public class Solutionb581 {
	
	public static void main(String args[]){
	}
	public int findUnsortedSubarray(int[] nums) {
		int min = 0, max = nums.length - 1;
		for (int i = 1; i < nums.length; i ++){
			if (i == min + 1 && nums[i] >= nums[i - 1]) min ++;
			while (min >= 0 && nums[i] < nums[min]) min --;
		}
		for (int i = nums.length - 2; i >= 0; i --){
			if (i == max - 1 && nums[i] <= nums[i + 1]) max --;
			while (max < nums.length && nums[i] > nums[max]) max ++;
		}
		return max - min - 1 < 0 ? 0 : max - min - 1;
	}
}