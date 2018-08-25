package leetcode;

import java.util.*;

//���� ����Ĳ�����������û��Ҫ����LeetCode�е��������ʾ���ķ���ת��
//����ֱ�����л�+�����л����ԣ�����DFS���Ա���LeetCode��BFSת���죬�����ˣ���˵�����ô
//(ԭ��ֻ��For Example�ٵ�BFS������)
class Codec_2 {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Queue<TreeNode> f = new LinkedList<TreeNode>();
		f.add(root);
		while (f.size() != 0){
			TreeNode x = f.poll();
			if (x == null) sb.append("null,");
			else {
				sb.append(x.val + ",");
				f.add(x.left);
				f.add(x.right);
			}
		}
		String result = sb.toString();
		while (result.endsWith("null,")) result = result.substring(0, result.length() - 5);
		return result.substring(0, result.length() - 1) + "]";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 1) return null;
		data = data.substring(1, data.length() - 1);
		String[] sp = data.split(",");
		if (sp.length == 0 || sp[0].equals("null")) return null;
		Queue<TreeNode> f = new LinkedList<TreeNode>();
		TreeNode result = new TreeNode(Integer.parseInt(sp[0]));
		f.add(result);
		int now = 1;
		while (now < sp.length){
			TreeNode x = f.poll();
			x.left = build(sp, now ++, f);
			if (now == sp.length) break;
			x.right = build(sp, now ++, f);
		}
		return result;
	}

	private TreeNode build(String[] sp, int i, Queue<TreeNode> f) {
		if (sp[i].equals("null")) return null;
		TreeNode result = new TreeNode(Integer.parseInt(sp[i]));
		f.add(result);
		return result;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));