package leetcode;

public class Solution74 {
	
	public static void main(String args[]){
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		int head = 0, tail = matrix.length - 1;
		while (head < tail){
			int mid = (head + tail) / 2 + 1;
			if (target == matrix[mid][0]) return true;
			if (target > matrix[mid][0]) head = mid; else tail = mid - 1;
		}
		int l = head;
		head = 0;
		tail = matrix[0].length - 1;
		while (head < tail){
			int mid = (head + tail) / 2;
			if (target > matrix[l][mid]) head = mid + 1; else tail = mid;
		}
		if (target == matrix[l][head]) return true;
		return false;
	}
}