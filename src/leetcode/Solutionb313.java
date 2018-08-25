package leetcode;

import java.util.*;

public class Solutionb313 {
	public static void main(String args[]){
		Solutionb313 s = new Solutionb313(); 
		int[] a = {2, 7, 13, 19};
		System.out.println(s.nthSuperUglyNumber(11, a));
	}
	//O(kn) -> O(logk*n)
	//记录已有的uglyNum + heap
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] now = new int[primes.length];
		int[] num = new int[n];
		Queue<int[]> heap = new PriorityQueue<int[]>(primes.length, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return a[0] - b[0];
			}
		});
		for (int i = 0; i < primes.length; i ++){
			now[i] = 1;
			heap.add(new int[]{primes[i], i});
		}
		int total = 1;
		num[0] = 1;
		while (total != n){
			int[] x = heap.poll();
			if (num[total - 1] != x[0]) num[total ++] = x[0];
			heap.add(new int[]{primes[x[1]] * num[now[x[1]] ++], x[1]});
		}
		return num[n - 1];
	}
}