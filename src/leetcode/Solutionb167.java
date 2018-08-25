package leetcode;

public class Solutionb167 {
	
	public static void main(String args[]){
		Solutionb167 s = new Solutionb167();
		int[] nums = {2, 7, 9, 11};
		int[] r = s.twoSum(nums, 9);
		System.out.println(r[0]+" "+r[1]);
	}
	public int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (true){
			while (r > l && numbers[l] + numbers[r] >= target) r --;
			if (r != numbers.length - 1) r ++;
			if (numbers[l] + numbers[r] == target) return new int[]{l + 1, r + 1};
			l ++;
		}
	}
}