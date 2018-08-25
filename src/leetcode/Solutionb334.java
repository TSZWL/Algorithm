package leetcode;

public class Solutionb334 {
	
	public static void main(String args[]){
		Solutionb334 s = new Solutionb334();
		int[] a = {5, 4, 3, 2, 1};
		System.out.println(s.increasingTriplet(a));
	}
	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3) return false;
		int a = nums[0], b = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i ++)
			if (nums[i] > a){
				if (nums[i] > b) return true;
				else b = nums[i];
			} else a = nums[i];
		return false;
	}
}