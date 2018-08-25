package leetcode;

import java.util.*;

public class Solutionb503 {
	public static void main(String args[]){
		Solutionb503 s = new Solutionb503();
		int[] a = {1,2,3,4,3};
		int[] r = s.nextGreaterElements(a);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i]);
	}
	Stack<Integer> num = new Stack<Integer>();
	Stack<Integer> pos = new Stack<Integer>();
	public int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		if (nums.length == 0) return result;
		for (int i = 0; i < nums.length; i ++) result[i] = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i ++){
			while (num.size() != 0 && nums[i] > num.peek()){
				num.pop();
				result[pos.pop()] = nums[i];
			}
			num.push(nums[i]);
			pos.push(i);
		}
		for (int i = 0; i < nums.length; i ++)
			while (num.size() != 0 && nums[i] > num.peek()){
				num.pop();
				result[pos.pop()] = nums[i];
			}
		while (pos.size() != 0) result[pos.pop()] = -1;
		return result;
	}
}