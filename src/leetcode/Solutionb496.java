package leetcode;

import java.util.*;

public class Solutionb496 {
	public static void main(String args[]){
		Solutionb496 s = new Solutionb496();
		int[] a = {4,1,2};
		int[] b = {1,3,4,2};
		int[] r = s.nextGreaterElement(a, b);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i]);
	}
	//ÓÖÍüÁËO(1)µÄmap¡£¡£
	Stack<Integer> num = new Stack<Integer>();
	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		if (nums1.length == 0) return result;
		for (int i = 0; i < nums2.length; i ++){
			while (num.size() != 0 && nums2[i] > num.peek()){
				m.put(num.pop(), nums2[i]);
			}
			num.push(nums2[i]);
		}
		for (int i = 0; i < nums1.length; i ++)
			result[i] = m.containsKey(nums1[i]) ? m.get(nums1[i]) : -1;
		return result;
	}
}