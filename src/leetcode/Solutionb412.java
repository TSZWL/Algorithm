package leetcode;

import java.util.*;

public class Solutionb412 {
	
	public static void main(String args[]){
	}
	public List<String> fizzBuzz(int n) {
		List<String> r = new ArrayList<String>();
		for (int i = 1; i <= n; i ++)
			if (i % 3 == 0) {
				if (i % 5 == 0) r.add("FizzBuzz");
				else r.add("Fizz");
			} else if (i % 5 == 0) r.add("Buzz");
			else r.add(String.valueOf(i));
		return r;
	}
}