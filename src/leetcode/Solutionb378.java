package leetcode;

import java.util.*;

public class Solutionb378 {
	
	public static void main(String args[]){
	}
	//���ִ𰸵ķ������� ÿһ�����ö�������м��������ڵ�ǰ�𰸵���
	//ʱ�临�Ӷ�O(klogn) -> O(log(maxInt)*nlogn)
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		Queue<int[]> q = new PriorityQueue<int[]>(n, (int[] a, int[] b) -> (matrix[a[0]][a[1]] - matrix[b[0]][b[1]]));
		for (int i = 0; i < n; i ++) q.add(new int[]{i, 0});
		for (int i = 0; i < k - 1; i ++) {
			int[] x = q.poll();
			if (++ x[1] < n) q.add(x);
		}
		int[] x = q.peek();
		return matrix[x[0]][x[1]];
	}
}