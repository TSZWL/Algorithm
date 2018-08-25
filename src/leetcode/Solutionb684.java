package leetcode;

public class Solutionb684 {
	
	public static void main(String args[]){
	}
	//第一次在leetcode写并查集
	int[] father;
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		father = new int[n + 1];
		for (int i = 1; i <= n; i ++) father[i] = i;
		for (int i = 0; i < n; i ++){
			int x = father(edges[i][0]);
			int y = father(edges[i][1]);
			if (x == y){
				return edges[i];
			} else {
				father[x] = y;
			}
		}
		return null;
	}
	private int father(int i) {
		if (father[i] == i) return i;
		father[i] = father(father[i]);
		return father[i];
	}
}