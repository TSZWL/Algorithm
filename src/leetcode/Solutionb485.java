package leetcode;

public class Solutionb485 {
	
	public static void main(String args[]){
		Solutionb485 s = new Solutionb485();
		int[] a = {1,1,0,1,1,1};
		System.out.println(s.findMaxConsecutiveOnes(a));
	}
	public int findMaxConsecutiveOnes(int[] nums) {
		int result = 0, now = 0;
		for (int i = 0; i < nums.length; i ++){
			if (nums[i] == 1) now ++; else now = 0;
			result = Math.max(result, now);
		}
		return result;
	}
}