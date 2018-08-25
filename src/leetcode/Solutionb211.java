package leetcode;

class WordDictionary {

	private dicNode root;
	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new dicNode();
	}
	
	/** Adds a word into the data structure. */
	public void addWord(String word) {
		dicNode l = root;
		for (char c : word.toCharArray()){
			if (l.next[c - 'a'] == null) l.next[c - 'a'] = new dicNode();
			l = l.next[c - 'a'];
		}
		l.isWord = true;
	}
	
	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return dfs(root, word.toCharArray(), 0);
	}

	private boolean dfs(dicNode l, char[] c, int p) {
		if (p == c.length) return l.isWord;
		if (c[p] == '.'){
			for (int i = 0; i < 26; i ++)
				if (l.next[i] != null && dfs(l.next[i], c, p + 1)) return true;
			return false;
		} else {
			if (l.next[c[p] - 'a'] == null) return false;
			else return dfs(l.next[c[p] - 'a'], c, p + 1);
		}
	}
}

class dicNode {
	dicNode[] next = new dicNode[26];
	boolean isWord = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */