package leetcode;

public class Solution42 {
	
	public static void main(String args[]){
		Solution42 s = new Solution42();
		int[] x = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(s.trap(x));
	}
	//直接看每一竖列有没有被围到。。
	/*public int trap(int[] height) {
		int result = 0;
		Stack<Integer> h = new Stack<Integer>();
		Stack<Integer> w = new Stack<Integer>();
		for (int i = 0; i < height.length; i ++){
			if (!h.isEmpty()){
				int last = h.peek();
				while ((!h.isEmpty()) && (h.peek() < height[i])){
					result += (i - w.pop() - 1) * (h.peek() - last);
					last = h.pop();
				}
				if (!h.isEmpty()) result += (i - w.peek() - 1) * (height[i] - last);
			}
			h.push(height[i]);
			w.push(i);
		}
		return result;
	}*/
	public int trap(int[] height) {
		if (height.length == 0) return 0;
		int result = 0;
		int[] max = new int[height.length];
		int[] min = new int[height.length];
		max[0] = height[0];
		min[height.length - 1] = height[height.length - 1];
		for (int i = 1; i < height.length; i ++) max[i] = Math.max(max[i - 1], height[i]);
		for (int i = height.length - 2; i >= 0; i --) min[i] = Math.max(min[i + 1], height[i]);
		for (int i = 1; i < height.length - 1; i ++)
			result += Math.min(max[i], min[i]) - height[i];
		return result;
	}
}