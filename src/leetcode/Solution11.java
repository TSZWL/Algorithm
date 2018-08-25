package leetcode;

public class Solution11 {
	public static void main(String args[]){
		Solution11 s = new Solution11();
		int[] a = {1, 1};
		System.out.println(s.maxArea(a));
	}
	//5min(线段树维护最大值，两遍)
    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1, r = 0;
        if (tail < 0) return r;
        while (head < tail){
        	int a = height[head], b = height[tail];
        	r = max((tail - head) * min(a, b), r);
        	if (height[head] > height[tail]){
        		tail --;
        		while ((tail > head) && (height[tail] < b)) tail --;
        	} else {
        		head ++;
        		while ((head < tail) && (height[head] < a)) head ++;
        	}
        	if (head == tail) break;
        }
        return r;
    }
	private int max(int a, int b) {
		if (a > b) return a; else return b;
	}
	private int min(int a, int b) {
		if (a > b) return b; else return a;
	}
}