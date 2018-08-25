package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb229 {
	
	public static void main(String args[]){
	}
	//+1 -1的方法?  重点.>超过
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		int n1 = 0, c1 = 0, n2 = 0, c2 = 0;
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] == n1) c1 ++;
			else if (nums[i] == n2) c2 ++;
			else if (c1 == 0){
				c1 = 1;
				n1 = nums[i];
			} else if (c2 == 0){
				c2 = 1;
				n2 = nums[i];
			} else {
				c1 --;
				c2 --;
			}
		c1 = 0;
		c2 = 0;
		for (int i = 0; i < nums.length; i ++)
			if (n1 == nums[i]) c1 ++;
			else if (n2 == nums[i]) c2 ++;
		if (c1 > nums.length / 3) result.add(n1);
		if (c2 > nums.length / 3) result.add(n2);
		return result;
	}
}