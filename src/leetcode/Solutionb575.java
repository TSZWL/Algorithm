package leetcode;

import java.util.*;

public class Solutionb575 {
	
	public static void main(String args[]){
	}
	public int distributeCandies(int[] candies) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : candies) set.add(i);
		return Math.min(set.size(), candies.length / 2);
	}
}