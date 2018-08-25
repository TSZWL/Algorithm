package leetcode;

import java.util.*;

public class Solutionb179 {
	
	public static void main(String args[]){
	}
	//每对数字之间排列先后的优劣具有传递性
	public String largestNumber(int[] nums) {
		String[] s = new String[nums.length];
		for (int i = 0; i < nums.length; i ++) s[i] = nums[i] + "";
		Arrays.sort(s, new Comparator<String>(){
			public int compare(String s1, String s2) {
				String a1 = s1 + s2;
				String a2 = s2 + s1;
				return a2.compareTo(a1);
			}
		});
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length; i ++) result.append(s[i]);
		if (result.toString().startsWith("0")) return "0";
		return result.toString();
	}
}