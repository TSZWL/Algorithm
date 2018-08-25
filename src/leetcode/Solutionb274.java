package leetcode;

import java.util.Arrays;

public class Solutionb274 {
	
	public static void main(String args[]){
		Solutionb274 s = new Solutionb274();
		int[] a = {3, 0, 6, 1, 5};
		System.out.println(s.hIndex(a));
	}
	//由于结果一定在0~n之间 所以直接采用桶排序即可。。
	//时间复杂度O(n)
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int n = citations.length;
		for (int i = 0; i < n; i ++)
			if (n - i <= citations[i]) return n - i;
		return 0;
	}
}