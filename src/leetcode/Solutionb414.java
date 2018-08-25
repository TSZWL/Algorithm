package leetcode;

public class Solutionb414 {
	
	public static void main(String args[]){
		Solutionb414 s = new Solutionb414();
		int[] a = {2, 2, 3, 1};
		System.out.println(s.thirdMax(a));
	}
	public int thirdMax(int[] nums) {
		int tot = 0;
		int[] max = new int[3];
		for (int i = 0; i < nums.length; i ++)
			for (int j = 0; j < 3; j ++){
				if (j == tot){
					max[tot] = nums[i];
					tot ++;
					break;
				}
				if (nums[i] == max[j]) break;
				if (nums[i] > max[j]){
					int n = max[j];
					max[j] = nums[i];
					nums[i] = n; 
				}
			}
		if (tot == 3) return max[2]; else return max[0];
	}
}