package leetcode;

public class Solutionb239 {
	
	public static void main(String args[]){
		Solutionb239 s = new Solutionb239();
		int[] a = {-7,-8,7,5,7,1,6,0};
		int[] r = s.maxSlidingWindow(a, 4);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i]);
	}
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0) return new int[0];
		int[] result = new int[nums.length - k + 1];
		int head = 0, tail = -1;
		int[] q = new int[nums.length];
		for (int i = 0; i < k; i ++){
			while (tail >= head && q[tail] < nums[i]) tail --;
			tail ++;
			q[tail] = nums[i];
		}
		result[0] = q[head];
		for (int i = k; i < nums.length; i ++){
			if (q[head] == nums[i - k]) head ++;
			while (tail >= head && q[tail] < nums[i]) tail --;
			tail ++;
			q[tail] = nums[i];
			result[i - k + 1] = q[head];
		}
		return result;
	}
}