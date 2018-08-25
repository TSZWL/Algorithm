package leetcode;

import java.util.*;

class BSTIterator {

	Stack<TreeNode> s = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while (root != null){
        	s.push(root);
        	root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!s.isEmpty()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode x = s.pop();
        int result = x.val;
        x = x.right;
        while (x != null){
        	s.push(x);
        	x = x.left;
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */