package leetcode;

public class Solutionb268 {
	
	public static void main(String args[]){
		Solutionb268 s = new Solutionb268();
		int[] a = {0, 1, 3};
		System.out.println(s.missingNumber(a));
	}
	public int missingNumber(int[] nums) {
		int l = nums.length;
		int x = l * (l + 1) / 2;
		for (int i = 0; i < l; i ++) x -= nums[i];
		return x;
	}
}