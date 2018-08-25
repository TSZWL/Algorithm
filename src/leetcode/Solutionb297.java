package leetcode;

import java.util.*;

//绝了 这题的测试用例根本没有要求按照LeetCode中的用数组表示树的方法转化
//而是直接序列化+反序列化测试，所以DFS明显比用LeetCode的BFS转化快，服气了，不说清楚的么
//(原来只是For Example举的BFS的例子)
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