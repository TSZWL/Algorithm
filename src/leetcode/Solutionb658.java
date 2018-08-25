package leetcode;

import java.util.*;

public class Solutionb658 {
	
	public static void main(String args[]){
		Solutionb658 s = new Solutionb658();
		int[] a = {0,1,1,1,2,3,6,7,8,9};
		List<Integer> r = s.findClosestElements(a, 4, 9);
		for (int i : r) System.out.println(i);
	}
	//根本不用从0开始扩展区间，顺推长度为k的窗口即可
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> r = new ArrayList<Integer>();
		int tail = arr.length - 1, head = 0;
		if (x > arr[tail]) x = arr[tail];
		if (x < arr[0]) x = arr[0];
		while (head < tail) {
			int mid = (head + tail) / 2 + 1;
			if (x >= arr[mid]) head = mid; else tail = mid - 1;
		}
		tail = arr.length - 1;
		if (head != tail && Math.abs(x - arr[head]) > Math.abs(x - arr[head + 1])) head ++;
		int now = head;
		for (int i = 1; i < k; i ++)
			if (head == 0) now ++;
			else if (now == tail) head --;
			else if (Math.abs(x - arr[head - 1]) > Math.abs(x - arr[now + 1])) now ++;
			else head --;
		for (int i = head; i <= now; i ++) r.add(arr[i]);
		return r;
	}
}