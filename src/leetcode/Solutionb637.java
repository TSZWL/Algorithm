package leetcode;

import java.util.*;

public class Solutionb637 {
	
	public static void main(String args[]){
	}
	List<Double> sum = new ArrayList<Double>();
	List<Integer> num = new ArrayList<Integer>();
	public List<Double> averageOfLevels(TreeNode root) {
		dfs(root, 0);
		for (int i = 0; i < sum.size(); i ++){
			sum.set(i, sum.get(i) / num.get(i));
		}
		return sum;
	}
	private void dfs(TreeNode root, int i) {
		if (root == null) return;
		if (sum.size() == i){
			sum.add(0.0);
			num.add(0);
		}
		sum.set(i, sum.get(i) + root.val);
		num.set(i, num.get(i) + 1);
		dfs(root.left, i + 1);
		dfs(root.right, i + 1);
	}
}