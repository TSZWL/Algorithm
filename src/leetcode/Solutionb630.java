package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solutionb630 {
	public static void main(String args[]){
		Solutionb630 s = new Solutionb630();
		int[][] a = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
		System.out.println(s.scheduleCourse(a));
	}
	//贪心；当当前所需时间大于可用时间时，在优先队列弹出最大的时间
	//Comparator的写法
	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		PriorityQueue<Integer> h = new PriorityQueue<>(10001, new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		int sum = 0;
		for (int i = 0; i < courses.length; i ++){
			sum += courses[i][0];
			h.add(courses[i][0]);
			if (sum > courses[i][1]) sum -= h.poll();
		}
		return h.size();
	}
}