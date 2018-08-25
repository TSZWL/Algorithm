package leetcode;

public class Solutionb525 {
	
	public static void main(String args[]){
		Solutionb525 s = new Solutionb525();
		int[] a = {0, 1, 0};
		System.out.println(s.findMaxLength(a));
	}
	public int findMaxLength(int[] nums) {
		int result = 0, now = 50000, l = nums.length;
		int[] p = new int[100001];
		for (int i = now - l; i <= now + l; i ++) p[i] = -2;
		p[now] = -1;
		for (int i = 0; i < l; i ++){
			if (nums[i] == 0) now --; else now ++;
			if (p[now] == -2){
				p[now] = i;
			} else {
				if (i - p[now] > result) result = i - p[now];
			}
		}
		return result;
	}
}