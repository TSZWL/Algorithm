package leetcode;

class TrieNode{
	TrieNode[] next;
	String word;
	TrieNode() {
		next = new TrieNode[26];
		word = null;
	}
}

/*public */class Trie {

	private TrieNode root;
	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}
	
	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode x = root;
		for (char c : word.toCharArray()){
			if (x.next[c - 'a'] == null) x.next[c - 'a'] = new TrieNode();
			x = x.next[c - 'a'];
		}
		x.word = word;
	}
    
	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode x = root;
		for (char c : word.toCharArray()){
			if (x.next[c - 'a'] == null) return false;
			x = x.next[c - 'a'];
		}
		if (x.word == null) return false;
		return true;
	}
    
	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode x = root;
		for (char c : prefix.toCharArray()){
			if (x.next[c - 'a'] == null) return false;
			x = x.next[c - 'a'];
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */