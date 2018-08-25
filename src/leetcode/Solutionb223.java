package leetcode;

public class Solutionb223 {
	
	public static void main(String args[]){
	}
	//两个面积的和减去交叉的面积
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int result = (C - A) * (D - B) + (G - E) * (H - F);
		int left = Math.max(A, E), right = Math.min(G, C);
		int bottom = Math.max(F, B), top = Math.min(D, H);
		if(right > left && top > bottom) result -= (right - left) * (top - bottom);
		return result;
	}
}