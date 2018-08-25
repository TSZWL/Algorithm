package leetcode;

public class Solutionb287 {
	
	public static void main(String args[]){
		Solutionb287 s = new Solutionb287();
		int[] a = {1, 2, 2};
		System.out.println(s.findDuplicate(a));
	}
	//久违的二分答案 判断有多少小于(head+tail)/2的数
	public int findDuplicate(int[] nums) {
		int head = 1, tail = nums.length - 1;
		while (head < tail){
			int mid = (head + tail) / 2, num = 0;
			for (int i = 0; i < nums.length; i ++)
				if (nums[i] <= mid) num ++;
			if (num <= mid) head = mid + 1; else tail = mid;
		}
		return head;
	}
}