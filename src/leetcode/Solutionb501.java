package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb501 {
	public static void main(String args[]){
	}
	List<Integer> n = new ArrayList<Integer>();
	List<Integer> p = new ArrayList<Integer>();
	int nownum = 0, nowval = 0, maxnum = 0;
	public int[] findMode(TreeNode root) {
		if (root != null){
			find(root);
			maxnum = Math.max(maxnum, nownum);
			n.add(nownum);
			p.add(nowval);
		}
		int num = 0, j = -1;
		for (int i : n)
			if (i == maxnum) num ++;
		int[] result = new int[num];
		num = 0;
		for (int i : n){
			j ++;
			if (i == maxnum){
				result[num] = p.get(j); 
				num ++;
			}
		}
		return result;
	}
	private void find(TreeNode root) {
		if (root.left != null) find(root.left);
		if (root.val != nowval){
			if (nownum != 0){
				maxnum = Math.max(maxnum, nownum);
				n.add(nownum);
				p.add(nowval);
			}
			nownum = 1;
			nowval = root.val;
		} else nownum ++;
		if (root.right != null) find(root.right);
	}
}