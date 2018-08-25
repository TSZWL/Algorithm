package leetcode;

public class Solutionb606 {
	
	public static void main(String args[]){
	}
	public String tree2str(TreeNode t) {
		if (t == null) return "";
		StringBuilder result = new StringBuilder("" + t.val);
		if (t.left == null){
			if (t.right != null) return result.append("()(" + tree2str(t.right) + ")").toString();
			else return result.toString();
		} else {
			result.append("(" + tree2str(t.left) + ")");
			if (t.right != null) return result.append("(" + tree2str(t.right) + ")").toString();
			else return result.toString();
		}
	}
}