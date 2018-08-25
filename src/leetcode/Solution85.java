package leetcode;

import java.util.Arrays;

public class Solution85 {
	
	public static void main(String args[]){
		Solution85 s = new Solution85();
		char[][] matrix = {{'1', '0', '1', '0', '0'},{'1', '0', '1', '1', '1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(s.maximalRectangle(matrix));
	}
	//还有一种写法和84类似
	//不过作为二维矩阵记录以heights[i]为上限的边界left[i]和right[i]可以递推得到
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;
		int l2 = matrix[0].length, result = 0;
		int[] left = new int[l2];
		int[] right = new int[l2];
		int[] height = new int[l2];
		Arrays.fill(right, l2);
		for (int i = 0; i < matrix.length; i ++){
			int l = 0, r = l2;
			for (int j = 0; j < l2; j ++)
				if (matrix[i][j] == '1')
					height[j] ++;
				else height[j] = 0;
			for (int j = 0; j < l2; j ++)
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], l);
				else {
					left[j] = 0;
					l = j + 1;
				}
			for (int j = l2 - 1; j >= 0; j --)
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], r);
				else {
					right[j] = l2;
					r = j;
				}
			for (int j = 0; j < l2; j ++)
				result = Math.max(result, height[j] * (right[j] - left[j]));
		}
		return result;
	}
}