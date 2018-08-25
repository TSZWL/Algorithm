package leetcode;

public class Solutionb546 {
	
	public static void main(String args[]){
		Solutionb546 s = new Solutionb546();
		int[] a = {6, 10, 1, 7, 1, 3, 10, 2, 1, 3};
		System.out.println(s.removeBoxes(a));
	}
	//t664
	//n^3的时间复杂度无法解决问题f[i+1][k]和f[k+1][j]无法确定f[i][j]
	//必须加入一维k表示最左边连续的元素个数
	//用dfs代替循环减少k带来的无用状态数
	public int removeBoxes(int[] boxes) {
		if (boxes.length == 0) return 0;
		int l = boxes.length;
		int[][][] f = new int[l][l][l];
		return dfs(boxes, f, 0, l - 1, 0);
	}
	private int dfs(int[] boxes, int[][][] f, int i, int j, int k) {
		if (i > j) return 0;
		if (f[i][j][k] != 0) return f[i][j][k];
		int ans = dfs(boxes, f, i + 1, j, 0) + (k + 1) * (k + 1);
		for (int l = i + 1; l <= j; l ++)
			if (boxes[i] == boxes[l])
				//合并连续的相同项提高效率
				ans = Math.max(ans, dfs(boxes, f, i + 1, l - 1, 0) + dfs(boxes, f, l, j, 1 + k));
		f[i][j][k] = ans;
		return ans;
	}
}
/*
public int removeBoxes(int[] boxes) {
if (boxes.length == 0) return 0;
int[] n = new int[boxes.length];
int[] g = new int[boxes.length];
g[0] = boxes[0];
n[0] = 1;
int l = 1;
for (int i = 1; i < boxes.length; i ++){
	if (boxes[i] != boxes[i - 1]) g[l ++] = boxes[i];
	n[l - 1] ++;
}
int[][] f = new int[l][l];
int[][] t = new int[l][l];
for (int i = 0; i < l; i ++){
	f[i][i] = n[i] * n[i];
	t[i][i] = n[i];
}
for (int i = 0; i < l - 1; i ++){
	f[i][i + 1] = n[i] * n[i] + n[i + 1] * n[i + 1];
	t[i][i + 1] = n[i];
}
for (int i = 2; i < l; i ++)
	for (int j = 0; j < l - i; j ++){
		f[j][j + i] = f[j + 1][j + i];
		t[j][j + i] = n[j];
		for (int k = j + 1; k < j + i; k ++)
			if (g[j] == g[k + 1]){
				int x = f[j + 1][k] + f[k + 1][j + i] + 2 * n[j] * t[k + 1][j + i];
				if (x >= f[j][j + i]){
					f[j][j + i] = x;
					t[j][j + i] = n[j] + t[k + 1][j + i];
				}
			}
		f[j][j + i] += n[j] * n[j];
	}
return f[0][l - 1];
}
*/