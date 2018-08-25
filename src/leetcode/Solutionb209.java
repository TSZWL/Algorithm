package leetcode;

public class Solutionb209 {
	
	public static void main(String args[]){
		Solutionb209 s = new Solutionb209();
		int[] a = {2,3,1,2,4,3};
		System.out.println(s.minSubArrayLen(7, a));
	}
	public int minSubArrayLen(int s, int[] nums) {
		if (s <= 0) return 0;
		int head = 0, tail = 0, min = Integer.MAX_VALUE, sum = 0;
		while (tail < nums.length){
			sum += nums[tail];
			tail ++;
			while (sum >= s){
				min = Math.min(min, tail - head);
				sum -= nums[head];
				head ++;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}