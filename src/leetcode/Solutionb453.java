package leetcode;

public class Solutionb453 {
	
	public static void main(String args[]){
	}
	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE, result = 0;
		for (int i = 0; i < nums.length; i ++) min = Math.min(min, nums[i]);
		for (int i = 0; i < nums.length; i ++) result += nums[i] - min;
		return result;
	}
}