package leetcode;

import java.util.*;

public class Solutionb202 {
	
	public static void main(String args[]){
	}
	Set<Integer> set = new HashSet<Integer>();
	public boolean isHappy(int n) {
		while (true){
			if (set.contains(n)) return false;
			set.add(n);
			int next = 0;
			while (n != 0){
				int a = n % 10;
				next += a * a;
				n = n / 10;
			}
			n = next;
			if (n == 1) return true;
		}
	}
}