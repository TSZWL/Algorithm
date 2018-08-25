package leetcode;

public class Solution41 {
	
	public static void main(String args[]){
		Solution41 s = new Solution41();
		int[] a = {3, 4, -1, 1};
		System.out.println(s.firstMissingPositive(a));
	}
	//常数空间：交换a[i]和a[a[i]]=>find a[i]!=i
	public int firstMissingPositive(int[] nums) {
		int l = nums.length;
		boolean[] b = new boolean[l + 1];
		for (int i = 0; i < l; i ++)
			if ((nums[i] > 0) && (nums[i] <= l)) b[nums[i] - 1] = true;
		for (int i = 0; i <= l; i ++)
			if (!b[i]) return i + 1;
		return 0;
	}
}