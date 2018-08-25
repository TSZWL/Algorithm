package leetcode;

public class Solutionb189 {
	
	public static void main(String args[]){
	}
	//O(n)~O(1)£¬Èý´Î·­×ª
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		deal(nums, 0, nums.length - k - 1);
		deal(nums, nums.length - k, nums.length - 1);
		deal(nums, 0, nums.length - 1);
	}
	public void deal(int[] f, int a, int b){
		for (int i = a; i < (a + b + 1) / 2; i ++){
			int n = f[i];
			f[i] = f[a + b - i];
			f[a + b - i] = n;
		}
	}
}