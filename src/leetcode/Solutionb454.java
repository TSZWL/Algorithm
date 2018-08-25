package leetcode;

import java.util.*;

public class Solutionb454 {
	public static void main(String args[]){
	}
	//HashMap.getOrDefault(jdk8
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int result = 0;
		for (int i = 0; i < C.length; i ++)
			for (int j = 0; j < D.length; j ++){
				int tot = - C[i] - D[j];
				if (!map.containsKey(tot)) map.put(tot, 1);
				else map.put(tot, map.get(tot) + 1);
			}
		for (int i = 0; i < A.length; i ++)
			for (int j = 0; j < B.length; j ++)
				if (map.containsKey(A[i] + B[j])){
					result += map.get(A[i] + B[j]);
				}
		return result;
	}
}