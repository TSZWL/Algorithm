package leetcode;

public class Solutionb572 {
	
	public static void main(String args[]){
	}
	int l1 = 0, l2 = 0;	
	public boolean isSubtree(TreeNode s, TreeNode t) {
		int[][] f = new int[10001][2];
		int[] g = new int[10001];
		dfs1(s, f);
		dfs2(t, g);
		for (int i = 0; i < l1; i ++)
			if (f[i][1] == l2) {
				boolean b = true;
				for (int j = 0; j < f[i][1]; j ++)
					if (f[i + j][0] != g[j]) {
						b = false;
						break;
					}
				if (b) return true;
			}
		return false;
	}
	private void dfs1(TreeNode s, int[][] f) {
		if (s == null) return;
		int now = l1;
		f[l1 ++][0] = s.val;
		dfs1(s.left, f);
		dfs1(s.right, f);
		f[now][1] = l1 - now;
	}
	private void dfs2(TreeNode t, int[] g) {
		if (t == null) return;
		g[l2 ++] = t.val;
		dfs2(t.left, g);
		dfs2(t.right, g);
	}
}
/*ֱ���ڵݹ��������ͺ���ô����
 *���Ǹо��ó�������ȽϿ찡����Ϊʲô����ô�ࡣ��Ϊ���˸��ݽڵ�����ɸѡ����
public boolean isSubtree(TreeNode s, TreeNode t) {
	return isSame(s, t) ||
    	(s != null && isSubtree(s.left, t)) ||
    	(s != null && isSubtree(s.right, t));
}
private boolean isSame(TreeNode s, TreeNode t) {
	if (s == null) return t == null;
	if (t == null) return false;
	if (s.val != t.val) return false;
	return isSame(s.left, t.left) && isSame(s.right, t.right);
}
*/