package leetcode;

import java.util.Arrays;

public class Solutionb495 {
	
	public static void main(String args[]){
		Solutionb495 s = new Solutionb495();
		int[] a = {1,4};
		System.out.println(s.findPoisonedDuration(a, 2));
	}
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0) return 0;
		Arrays.sort(timeSeries);
		int begin = timeSeries[0], end = begin + duration, result = 0;
		for (int i = 0; i < timeSeries.length; i ++){
			if (timeSeries[i] <= end) end = timeSeries[i] + duration;
			else {
				result += end - begin;
				begin = timeSeries[i];
				end = timeSeries[i] + duration;
			}
		}
		result += end - begin;
		return result;
	}
}