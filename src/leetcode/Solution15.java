package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution15 {
	public static void main(String args[]){
		Solution15 s = new Solution15();
		int[] a = {-2, 0, 1, 3, 1, 2};
		List<List<Integer>> x = s.threeSum(a);
		for (List<Integer> i : x){
			for (Integer j : i) System.out.print(j + " ");
			System.out.println();
		}
	}
	//其实不用分出来2个一样的情况
	public List<List<Integer>> threeSum(int[] nums) {
		int l1 = nums.length, l = 1;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (l1 == 0) return result;
		int b[] = new int[nums.length];
		//for (int i = 0; i < l1; i ++)  排序写错了都能AC？
		//for (int j = 0; j < l1; j ++)  仔细想想没写错
		for (int i = 0; i < l1 - 1; i ++)
			for (int j = i + 1; j < l1; j ++)
				if (nums[i] > nums[j]){
					int n = nums[i];
					nums[i] = nums[j];
					nums[j] = n;
				}
		for (int i = 0; i < nums.length; i ++) System.out.println(nums[i]);
		for (int i = 1; i < l1; i ++)
			if (nums[i] != nums[l - 1]){
				nums[l] = nums[i];
				l ++;
			} else b[l - 1] ++;
		for (int i = 0; i < l; i ++)
			if (b[i] != 0)
				for (int j = 0; j < l; j ++)
					if ((nums[j] == -2 * nums[i]) && ((i != j) || (b[i] > 1))){
						List<Integer> n = new ArrayList<Integer>();
						n.add(nums[j]);
						n.add(nums[i]);
						n.add(nums[i]);
						result.add(n);
						break;
					}
		for (int i = 1; i < l - 1; i ++){
			int head = i - 1, tail = i + 1;
			while ((head >= 0) && (tail < l)){
				int sum = nums[i] + nums[head] + nums[tail];
				if (sum == 0){
					List<Integer> n = new ArrayList<Integer>();
					n.add(nums[i]);
					n.add(nums[head]);
					n.add(nums[tail]);
					result.add(n);
					tail ++;head --;
				} else if (sum > 0){
					head --;
				} else tail ++;
			}
		}
		return result;
	}
}