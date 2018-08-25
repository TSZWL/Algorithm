package leetcode;

public class Solutionb456 {
	
	public static void main(String args[]){
		Solutionb456 s = new Solutionb456();
		int[] a = {-1, 3, 2, 0};
		System.out.println(s.find132pattern(a));
	}
	//从大到小的区间排列，每次从队列尾淘汰，淘汰完比较
	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) return false;
		int head = 0, tail = 0;
		int[] low = new int[nums.length], high = new int[nums.length];
		low[0] = nums[0];
		high[0] = Integer.MIN_VALUE; 
		for (int i = 1; i < nums.length; i ++){
			int t = tail;
			while (tail >= head && nums[i] >= high[tail]) tail --;
			if (tail >= head && nums[i] < high[tail] && nums[i] > low[tail]) return true;
			if (tail != t) tail ++;
			low[tail] = low[t];
			if (nums[i] > low[tail]) high[tail] = Math.max(nums[i], high[t]);
			if (nums[i] < low[tail]){
				tail ++;
				high[tail] = Integer.MIN_VALUE;
				low[tail] = nums[i];
			}
		}
		return false;
	}
}