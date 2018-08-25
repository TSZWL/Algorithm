package leetcode;

public class Solutionb645 {
	
	public static void main(String args[]){
		Solutionb645 s = new Solutionb645();
		int[] a = {1, 2, 2, 4};
		int[] r = s.findErrorNums(a);
		System.out.println(r[0] + " " + r[1]);
	}
	public int[] findErrorNums(int[] nums) {
		int l = nums.length, r = 0;
		int tot = l * (l + 1) / 2;
		boolean[] b = new boolean[l + 1];
		for (int i = 0; i < l; i ++)
			if (!b[nums[i]]){
				b[nums[i]] = true;
				tot -= nums[i];
			} else r = nums[i];
		return new int[]{r, tot};
	}
}