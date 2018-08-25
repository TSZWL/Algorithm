package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solutionb219 {
	
	public static void main(String args[]){
		Solutionb219 s = new Solutionb219();
		int[] a = {1, 2};
		int b = 2;
		System.out.println(s.containsNearbyDuplicate(a, b));
	}
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		int[][] p = new int[nums.length][2];
		for (int i = 0; i < nums.length; i ++){
			p[i][0] = nums[i];
			p[i][1] = i;
		}
		Arrays.sort(p, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				int[] one = (int[]) o1;
				int[] two = (int[]) o2;
				if (one[0] > two[0]) return 1;
				if (one[0] < two[0]) return -1;
				if (one[1] > two[1]) return 1;
				if (one[1] < two[1]) return -1;
				return 0;
			}
		});
		for (int i = 0; i < p.length - 1; i ++)
			if (p[i][0] == p[i + 1][0] && p[i + 1][1] - p[i][1] <= k)
				return true;
		return false;
	}
}