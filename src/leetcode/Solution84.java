package leetcode;

public class Solution84 {
	
	public static void main(String args[]){
		Solution84 s = new Solution84();
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println(s.largestRectangleArea(heights));
	}
	//比较的是以每一列开始的面积
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0) return 0;
		int[] h = new int[heights.length + 1];
		int[] node = new int[heights.length + 1];
		int head = 0, result = 0;
		h[0] = -1;node[0] = -1;
		for (int i = 0; i < heights.length; i ++){
			while (h[head] >= heights[i]){
				result = Math.max(result, h[head] * (i - node[head - 1] - 1));
				head --;
			}
			head ++;
			h[head] = heights[i];
			node[head] = i;
		}
		for (int i = 1; i <= head; i ++)
			result = Math.max(result, h[i] * (heights.length - node[i - 1] - 1));
		return result;
	}
}