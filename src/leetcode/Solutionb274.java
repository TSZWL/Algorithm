package leetcode;

import java.util.Arrays;

public class Solutionb274 {
	
	public static void main(String args[]){
		Solutionb274 s = new Solutionb274();
		int[] a = {3, 0, 6, 1, 5};
		System.out.println(s.hIndex(a));
	}
	//���ڽ��һ����0~n֮�� ����ֱ�Ӳ���Ͱ���򼴿ɡ���
	//ʱ�临�Ӷ�O(n)
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int n = citations.length;
		for (int i = 0; i < n; i ++)
			if (n - i <= citations[i]) return n - i;
		return 0;
	}
}