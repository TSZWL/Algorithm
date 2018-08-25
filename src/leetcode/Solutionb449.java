package leetcode;

class Codec {

	private int l = 0;
    // Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) return "n:";
		String r = root.val + ":";
		r += serialize(root.left);
		r += serialize(root.right);
		return r;
	}

    // Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] r = data.split(":");
		l = -1;
		return build(r);
	}

	private TreeNode build(String[] r) {
		l ++;
		if (r[l].equals("n")) return null;
		TreeNode result = new TreeNode(Integer.parseInt(r[l]));
		result.left = build(r);
		result.right = build(r);
		return result;
	}
/*通过加入max min上下限标识，可以不记入null
	private TreeNode helper2(char[] input , int min , int max) {
        if (index >= input.length || Integer.valueOf(input[index]) >= max || Integer.valueOf(input[index]) <= min) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(input[index++]));
        root.left = helper2(input , min,Integer.valueOf(root.val));
        root.right = helper2(input , Integer.valueOf(root.val) , max);
        
        return root;
    }
   */
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));