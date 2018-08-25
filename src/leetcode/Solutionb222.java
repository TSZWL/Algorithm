package leetcode;

public class Solutionb222 {
	public static void main(String args[]){
	}
	//ֻҪ�Ƚ�һ�����������ĵ�һ����ĸ߶�
	//Ȼ��ֱ��������������ƾͿ����ˡ�����
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		TreeNode now = root;
		int depth = 0;
		while (now != null){
			depth ++;
			now = now.left;
		}
		int[] f = new int[depth - 1];
		for (int i = 0; i < depth - 1; i ++) f[i] = 1 << i; 
		int head = (int)Math.pow(2, depth - 1), tail = (int)Math.pow(2, depth) - 1;
		while (head < tail){
			int mid = (head + tail) / 2 + 1;
			int i = depth - 2;
			now = root;
			while (i >= 0){
				if ((mid & f[i]) == 0) now = now.left; else now = now.right;
				i --;
			}
			if (now == null) tail = mid - 1; else head = mid;
		}
		return head;
	}
}