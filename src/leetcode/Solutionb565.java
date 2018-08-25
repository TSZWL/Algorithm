package leetcode;

public class Solutionb565 {
	
	public static void main(String args[]){
		Solutionb565 s = new Solutionb565();
		int[] a = {5,4,0,3,1,6,2};
		System.out.println(s.arrayNesting(a));
	}
	public int arrayNesting(int[] nums) {
		int max = 0;
		boolean[] b = new boolean[nums.length];
		for (int i = 0; i < nums.length; i ++)
			if (!b[i]){
				b[i] = true;
				int x = 1, l = nums[i];
				while (!b[l]){
					b[l] = true;
					l = nums[l];
					x ++;
				}
				max = Math.max(max, x);
			}
		return max;
	}
}